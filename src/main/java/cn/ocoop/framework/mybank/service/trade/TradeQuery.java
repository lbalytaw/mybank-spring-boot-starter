package cn.ocoop.framework.mybank.service.trade;

import cn.ocoop.framework.mybank.ServiceRequest;
import cn.ocoop.framework.mybank.ServiceResponse;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 转账入账
 */
public class TradeQuery {
    public static final String SERVICE = "mybank.tc.trade.info.query";

    @EqualsAndHashCode(callSuper = true)
    @Data
    @Builder
    @ToString(callSuper = true)
    public static class Request extends ServiceRequest<Response> {

        /**
         * 不可空
         * <p>
         * 业务平台订单号
         * <p>
         * 20101018001052601340052
         */
        private String outer_trade_no;

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
         * 标识商户交易订单的唯一凭证号
         * <p>
         * 20101018001052601340052
         */
        private String outer_trade_no;
        /**
         * 不可空
         * <p>
         * 云资金平台交易凭证号
         * <p>
         * 2013110514543
         */
        private String inner_trade_no;
        /**
         * 不可空
         * <p>
         * 平台专属出款渠道
         * <p>
         * 2013110514543
         */
        private String outer_inst_order_no;
        /**
         * 可空
         * <p>
         * 业务产品码
         */
        private String product_code;
        /**
         * 可空
         * <p>
         * 商品的标题/交易标题/订单标题/订
         * <p>
         * 单关键字等。
         * <p>
         * 油漆
         */
        private String subject;
        /**
         * 不可空
         * <p>
         * 交易金额，精确到小数点后两位
         * <p>
         * 656.00
         */
        private String trade_amount;
        /**
         * 可空
         * <p>
         * 折扣金额，精确到小数点后两位
         * <p>
         * 1.00
         */
        private String discount_amount;
        /**
         * 可空
         * <p>
         * 买家手续费，精确到小数点后两位
         * <p>
         * 1.00
         */
        private String buyer_fee;
        /**
         * 可空
         * <p>
         * 卖家手续费，精确到小数点后两位
         * <p>
         * 1.00
         */
        private String seller_fee;
        /**
         * 可空
         * <p>
         * 失败原因
         */
        private String fail_reason;
        /**
         * 不可空
         * <p>
         * 交易创建时间.数字串，一共 14 位格式为：年[4 位]月 [2 位]日[2 位]时[2
         * <p>
         * 位]分[2 位]秒[2 位]
         * <p>
         * 20131117020101
         */
        private String trade_time;
        /**
         * 不可空
         * <p>
         * 来账识别交易状态如下：
         * <p>
         * SUCCESS成功
         * <p>
         * ON_ACCOUNT已挂账
         * <p>
         * CANCEL_SUCCESS 已销账
         * <p>
         * <p>
         * 提现交易状态如下：
         * <p>
         * <p>
         * TRADE_FINISHED 提现成功
         * <p>
         * TRADE_FAILED 提现失败
         * <p>
         * REFUND_TICKET 退票成功
         */
        private String trade_status;
    }
}
