package cn.ocoop.framework.mybank.service.notify;

import cn.ocoop.framework.mybank.ServiceRequest;
import cn.ocoop.framework.mybank.ServiceResponse;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

public class NotifyMock {
    public static final String SERVICE = "mybank.tc.trade.remit.subaccount";

    @EqualsAndHashCode(callSuper = true)
    @Data
    @Builder
    @ToString(callSuper = true)
    public static class Request extends ServiceRequest<Response> {

        /**
         * 可空
         * <p>
         * 付款方卡号
         * <p>
         * 20131105154925
         */
        private String payer_card_no;
        /**
         * 可空
         * <p>
         * 付款方户名
         * <p>
         * 张三
         */
        private String payer_card_name;
        /**
         * 不可空
         * <p>
         * 收款方卡号
         * <p>
         * 5501005165714
         */
        private String payee_card_no;
        /**
         * 可空
         * <p>
         * 收款方户名
         * <p>
         * 李四
         */
        private String payee_card_name;
        /**
         * 可空
         * <p>
         * 汇入金额（单位：分），默认100分，即：1元
         * <p>
         * 100
         */
        private long amount;
        /**
         * 可空
         * <p>
         * 支付备注
         * <p>
         * 汇款
         */
        private String payer_remark;
        /**
         * 不可空
         * <p>
         * 通知地址
         * <p>
         * http://xxx.vf.cn/xx/asynNotify.htm
         */
        private String notify_url;

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
