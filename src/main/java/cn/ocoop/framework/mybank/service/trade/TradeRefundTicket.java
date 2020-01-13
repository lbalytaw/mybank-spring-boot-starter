package cn.ocoop.framework.mybank.service.trade;

import cn.ocoop.framework.mybank.ServiceRequest;
import cn.ocoop.framework.mybank.ServiceResponse;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

public class TradeRefundTicket {
    public static final String SERVICE = "mybank.tc.trade.refundticket";

    @EqualsAndHashCode(callSuper = true)
    @Data
    @Builder
    @ToString(callSuper = true)
    public static class Request extends ServiceRequest<Response> {

        /**
         * 不可空
         * <p>
         * 业务平台请求号
         * <p>
         * 20101018001052601340053
         */
        private String request_no;
        /**
         * 不可空
         * <p>
         * 合作方对接出款渠道使用的提现订单号。若出款渠道是网商银行，则此处填写与outer_trade_no保持一致。
         * <p>
         * 20101018001052601340052
         */
        private String orig_outer_inst_order_no;

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
