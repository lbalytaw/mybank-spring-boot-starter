package cn.ocoop.framework.mybank.service.account;

import cn.ocoop.framework.mybank.ServiceRequest;
import cn.ocoop.framework.mybank.ServiceResponse;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

public class AccountBalanceGet {
    public static final String SERVICE = "mybank.tc.user.account.balance";

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
         * U500000001
         */
        private String uid;
        /**
         * 可空
         * <p>
         * 账户类型，若为空，则默认查询会员所有账户
         * <p>
         * BASIC
         */
        private String account_type;
        /**
         * 可空
         * <p>
         * 预留字段，不必填
         */
        private String account_identity;

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
         * 合作方业务平台用户ID
         * <p>
         * U500000001
         */
        private String uid;

        /**
         * 账户列表
         */
        private List<AccountBalance> account_list;

        @Data
        public static class AccountBalance {
            /**
             * 不可空
             * <p>
             * 会员账户号
             * <p>
             * 200100100210000369876500001
             */
            private String account_id;
            /**
             * 不可空
             * <p>
             * 账户类型
             * <p>
             * BASIC
             */
            private String account_type;
            /**
             * 不可空
             * <p>
             * 账面余额。单位为：RMB   Yuan。精确到小数点后两位。
             * <p>
             * 10.00
             */
            private String balance;
            /**
             * 不可空
             * <p>
             * 可用余额。单位为：RMB   Yuan。精确到小数点后两位。
             * <p>
             * 8.00
             */
            private String available_balance;
            /**
             * 可空
             * <p>
             * 子账户号
             * <p>
             * 4992739872
             */
            private String sub_account_no;
        }

    }
}
