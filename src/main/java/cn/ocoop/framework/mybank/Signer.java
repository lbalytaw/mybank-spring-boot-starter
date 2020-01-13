package cn.ocoop.framework.mybank;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.wxmlabs.aurora.CMSSigner;
import com.wxmlabs.aurora.SignatureService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static cn.ocoop.framework.mybank.MybankProperties.ConfiguredKeyStore;

@Slf4j
public class Signer {
    private static final Set<String> EXCLUDE_KEY = Sets.newHashSet("sign", "SIGN", "sign_type", "SIGN_TYPE", "response");
    private static SignatureService signatureService;
    private static MybankProperties mybankProperties;

    static {
        // 初始化证书
        ConfiguredKeyStore configuredKeyStore = null;
        try {
            mybankProperties = MybankAutoConfiguration.ctx.getBean(MybankProperties.class);
            configuredKeyStore = mybankProperties.getConfiguredKeyStore();
        } catch (Exception e) {
            log.error("无法获取配置的证书");
        }

        if (configuredKeyStore == null) {
            configuredKeyStore = new ConfiguredKeyStore("PKCS12", "", "default.pfx", "mayibank");
        }

        signatureService = TCACompatibleSignatureService.getInstance(configuredKeyStore);
    }

    public static Map<String, String> sign(ServiceRequest request) throws Exception {
        Map<String, String> requestParam = toBeSignField(request);

        String linkString = createLinkString(requestParam, false);
        log.info("原文：{}", linkString);
        CMSSigner cmsSigner = getSigner();

        // 不带原文
        String signature = Base64.encodeBase64String(cmsSigner.sign(linkString.getBytes(StandardCharsets.UTF_8)));
        log.info("签名：{}", signature);

        requestParam.put("sign", signature);
        requestParam.put("sign_type", request.getSign_type());
        return requestParam;
    }

    public static boolean verify(HttpServletRequest request) {

        Map<String, String> parameterMap = Maps.newHashMap();
        Enumeration<String> parameterNames = request.getParameterNames();

        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);

            if (EXCLUDE_KEY.contains(paramName) || paramValues.length != 1 || StringUtils.isBlank(paramValues[0]))
                continue;

            parameterMap.put(paramName, paramValues[0]);
        }

        String linkString = createLinkString(parameterMap, false);

        try {
            return RSA.verify(linkString, request.getParameter("sign"), mybankProperties.getPublicKey(), mybankProperties.getCharset());
        } catch (Exception e) {
            log.error("签名验证失败", e);
        }
        return false;
    }

    private static Map<String, String> toBeSignField(ServiceRequest request) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Map<String, String> requestParam = Maps.newHashMap();

        Map<String, String> describe = BeanUtils.describe(request);
        for (Map.Entry<String, String> kv : describe.entrySet()) {
            if (EXCLUDE_KEY.contains(kv.getKey()) || StringUtils.isBlank(kv.getValue())) continue;

            requestParam.put(kv.getKey(), kv.getValue());
        }
        return requestParam;
    }

    private static CMSSigner getSigner() throws Exception {
        for (String name : signatureService.listSigner()) {
            if ("default".equals(name.split("_")[0])) return (CMSSigner) signatureService.findSignerByName(name);
        }
        throw new Exception("证书不存在。");
    }

    /**
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     *
     * @param params 需要排序并参与字符拼接的参数组
     * @param encode 是否需要urlEncode
     * @return 拼接后字符串
     */
    public static String createLinkString(Map<String, String> params, boolean encode) {

        //        params = paraFilter(params);

        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);

        StringBuilder prestr = new StringBuilder();

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);
            if (encode) {
                try {
                    value = URLEncoder.encode(value, "utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
                prestr.append(key).append("=").append(value);
            } else {
                prestr.append(key).append("=").append(value).append("&");
            }
        }

        return prestr.toString();
    }

}
