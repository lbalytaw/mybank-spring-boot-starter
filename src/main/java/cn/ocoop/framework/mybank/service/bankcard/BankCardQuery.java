package cn.ocoop.framework.mybank.service.bankcard;

import cn.ocoop.framework.mybank.ServiceRequest;
import cn.ocoop.framework.mybank.ServiceResponse;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

public class BankCardQuery {
    public static final String SERVICE = "mybank.tc.user.bankcard.query";

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
         * 有效的银行卡列表
         */
        private List<Bank> bank_list;

        @Data
        public static class Bank {
            /**
             * 银行卡id
             * <p>
             * 100056
             */
            private String bank_id;
            /**
             * 不可空
             * <p>
             * 银行编号 见附录
             * <p>
             * ICBC,CCB
             */
            private String bank_code;
            /**
             * 不可空
             * <p>
             * 银行全称 见附录
             * <p>
             * 中国工商银行
             */
            private String bank_name;
            /**
             * 不可空
             * <p>
             * 银行卡号。明文
             */
            private String bank_account_no;
            /**
             * 不可空
             * <p>
             * 开户名。明文
             */
            private String account_name;
            /**
             * 不可空
             * <p>
             * 省份
             * <p>
             * 上海市，江苏省
             */
            private String province;
            /**
             * 不可空
             * <p>
             * 城市
             * <p>
             * 上海市，南京市
             */
            private String city;
            /**
             * 不可空
             * <p>
             * 支行号（联行号）
             */
            private String branch_no;
            /**
             * 不可空
             * <p>
             * 分支行名称
             */
            private String bank_branch;
            /**
             * 可空
             * <p>
             * 预留手机号
             * <p>
             * 13788888888
             */
            private String reserved_mobile;
            /**
             * 可空
             * <p>
             * 卡支付属
             * <p>
             * NORMAL
             */
            private String pay_attribute;
            /**
             * 可空
             * <p>
             * 卡属性
             * <p>
             * C    对私
             * <p>
             * B    对公
             */
            private String card_attribute;
            /**
             * 可空
             * <p>
             * 卡类型
             * <p>
             * 卡类型
             * <p>
             * DC   借记
             * <p>
             * CC   贷记（信用卡）
             * <p>
             * PB   存折
             * <p>
             * OC   其他
             */
            private String card_type;
            /**
             * 可空
             * <p>
             * 证件号
             */
            private String certificate_no;
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
             * 验证状态
             * <p>
             * UNVERIFIED:未认证   VERIFIED:已认证
             */
            private String is_verified;
        }
    }
}
