package cn.ocoop.framework.mybank.service.bankcard;

import cn.ocoop.framework.mybank.ServiceRequest;
import cn.ocoop.framework.mybank.ServiceResponse;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

public class BankCardBind {
    public static final String SERVICE = "mybank.tc.user.bankcard.bind";

    @EqualsAndHashCode(callSuper = true)
    @Data
    @Builder
    @ToString(callSuper = true)
    public static class Request extends ServiceRequest<Response> {

        /**
         * 不可空
         * <p>
         * 合作方业务平台用户ID
         * <p>
         * 10010020304
         */
        private String uid;
        /**
         * 不可空
         * <p>
         * 银行全称
         * <p>
         * 中国工商银行
         */
        private String bank_name;
        /**
         * 可空
         * <p>
         * 支行名称
         * <p>
         * 中国工商银行南京南山支行
         */
        private String bank_branch;
        /**
         * 可空
         * <p>
         * 联行号非必填
         * <p>
         * 313703018022
         */
        private String branch_no;
        /**
         * 不可空
         * <p>
         * 银行账号/卡号，明文。
         * <p>
         * 6225885425698745
         */
        private String bank_account_no;
        /**
         * 不可空
         * <p>
         * 银行开户名，明文。
         * <p>
         * 测试用户
         */
        private String account_name;
        /**
         * 不可空
         * <p>
         * 卡类型
         * <p>
         * DC   借记
         * <p>
         * CC   贷记（信用卡）
         * <p>
         * 目前仅支持
         * <p>
         * 借记、贷记
         */
        private String card_type;
        /**
         * 不可空
         * <p>
         * 卡属性：
         * <p>
         * C    对私
         * <p>
         * B    对公
         * <p>
         * C
         */
        private String card_attribute;
        /**
         * 可空
         * <p>
         * 验证类型
         * <p>
         * 3:三要素验证
         * <p>
         * 4:四要素验证
         */
        private String verify_type;
        /**
         * 可空
         * <p>
         * 证件类型
         * <p>
         * 见附录证件类型
         */
        private String certificate_type;
        /**
         * 可空
         * <p>
         * 证件号
         */
        private String certificate_no;
        /**
         * 可空
         * <p>
         * 省份
         * <p>
         * 江苏省
         */
        private String province;
        /**
         * 可空
         * <p>
         * 城市
         * <p>
         * 南京市
         */
        private String city;
        /**
         * 可空
         * <p>
         * 银行预留手机号
         * <p>
         * 13788888888
         */
        private String reserved_mobile;
        /**
         * 可空
         * <p>
         * 支付属性：
         * <p>
         * NORMAL 普通(默认)
         * <p>
         * NORMAL
         */
        private String pay_attribute;


        @Override
        public String getService() {
            return SERVICE;
        }
    }


    @EqualsAndHashCode(callSuper = true)
    @Data
    @ToString(callSuper = true)
    public static class Response extends ServiceResponse {

        /**
         * 不可空
         * <p>
         * 银行卡id，银行卡在交易见证平台的绑卡id
         */
        private String bank_id;
    }
}
