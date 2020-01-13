package cn.ocoop.framework.mybank.service.bankcard;

import cn.ocoop.framework.mybank.ServiceRequest;
import cn.ocoop.framework.mybank.ServiceResponse;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

public class BankCardUnbind {
    public static final String SERVICE = "mybank.tc.user.bankcard.unbind";

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
         * 银行卡id，银行卡在交易见证平台的绑卡id
         * <p>
         * 10023
         */
        private String bank_id;

        @Override
        public String getService() {
            return SERVICE;
        }

    }


    @EqualsAndHashCode(callSuper = true)
    @Data
    @ToString(callSuper = true)
    public static class Response extends ServiceResponse {

    }
}
