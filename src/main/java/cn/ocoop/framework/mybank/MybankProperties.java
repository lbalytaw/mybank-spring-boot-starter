package cn.ocoop.framework.mybank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@Data
@RefreshScope
@ConfigurationProperties(prefix = MybankProperties.PREFIX)
public class MybankProperties {
    public static final String PREFIX = "mybank";
    private String gatewayUrl = "http://test.tc.mybank.cn/gop/gateway.do";
    /**
     * 接口版本，设置为2.1
     */
    private String version = "2.1";
    /**
     * 云资金管理平台分配给合作方业务平台签约唯一ID
     */
    private String partnerId = "200002007807";
    /**
     * 合作方业务平台使用的编码格式，如utf-8、gbk、gb2312等
     */
    private String charset = "UTF-8";
    /**
     * 签名方式只支持TWSIGN
     */
    private String signType = "TWSIGN";
    /**
     * 平台专属出款渠道编码，该栏位的可选列表由网商银行小二根据平台递交的申请表分配并反馈
     */
    private String whiteChannelCode = "MYBANK00097";
    /**
     * 平异步通知验签公钥
     */
    private String publicKey = "uJlmEUWgAbmDPfIOhysHrvjjq1QPXL5OsmaIK6jc2Af1LXn9zKdeLdDXaSyBMp1jdmVUnwtJxCCRm58Y/8GfXydizODq/5N9qDP5aBWmBqR8ikTxdgrj12F2vTWqK0VFlI5EKw0eSVyNRGn5nOvxItp1/I+TRjqRD2FnlSEEmFM=";

    /**
     * 收款人名称
     */
    private String payeeName;
    /**
     * 收款人帐号
     */
    private String payeeAccount;
    /**
     * 开户行名称
     */
    private String payeeBank = "浙江网商银行";

    private ConfiguredKeyStore configuredKeyStore;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ConfiguredKeyStore {
        private String type;
        private String provider;
        private String path;
        private String password;
    }
}
