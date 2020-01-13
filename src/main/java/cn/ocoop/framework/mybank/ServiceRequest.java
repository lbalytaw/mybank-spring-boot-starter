package cn.ocoop.framework.mybank;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Map;

@Slf4j
@Data
public abstract class ServiceRequest<T extends ServiceResponse> {
    private String version = "2.1";
    private String partner_id = "200002007807";
    private String charset = "UTF-8";
    private String sign_type = "TWSIGN";
    private String sign;
    private String service;
    private String memo;

    public ServiceRequest() {
        try {
            MybankProperties config = MybankAutoConfiguration.ctx.getBean(MybankProperties.class);
            this.version = config.getVersion();
            this.partner_id = config.getPartnerId();
            this.charset = config.getCharset();
            this.sign_type = config.getSignType();
        } catch (Exception e) {
            log.error("无法获取网商配置信息");
        }
    }

    private static RestTemplate getTemplate() {
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setConnectionRequestTimeout(3000);
        httpRequestFactory.setConnectTimeout(3000);
        httpRequestFactory.setReadTimeout(5000);
        BufferingClientHttpRequestFactory factory = new BufferingClientHttpRequestFactory(httpRequestFactory);
        RestTemplate restTemplate = new RestTemplate(factory);
        for (HttpMessageConverter<?> httpMessageConverter : restTemplate.getMessageConverters()) {
            if (httpMessageConverter instanceof StringHttpMessageConverter) {
                ((StringHttpMessageConverter) httpMessageConverter).setDefaultCharset(Charset.forName("UTF-8"));
            }
            if (httpMessageConverter instanceof MappingJackson2HttpMessageConverter) {
                ((MappingJackson2HttpMessageConverter) httpMessageConverter).getObjectMapper()
                        .setSerializationInclusion(JsonInclude.Include.NON_NULL);
//                        .setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
            }
        }
        restTemplate.setInterceptors(Collections.singletonList(new RequestResponseLoggingInterceptor()));
        return restTemplate;
    }

    public T exec() throws Exception {
        Class<T> response = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Map<String, String> body = Signer.sign(this);
        HttpHeaders header = new HttpHeaders();
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        if (MapUtils.isNotEmpty(body)) {
            body.forEach(map::add);
        }
        HttpEntity<Object> httpEntity = new HttpEntity<>(map, header);

        String gatewayUrl;
        try {
            gatewayUrl = MybankAutoConfiguration.ctx.getBean(MybankProperties.class).getGatewayUrl();
        } catch (Exception e) {
            gatewayUrl = "http://test.tc.mybank.cn/gop/gateway.do";
        }

        String responseData = getTemplate().exchange(gatewayUrl, HttpMethod.POST, httpEntity, String.class).getBody();
        return JSON.parseObject(responseData, response);
    }
}
