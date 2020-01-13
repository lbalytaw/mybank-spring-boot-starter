package cn.ocoop.framework.mybank.service.trade;

import cn.ocoop.framework.mybank.ServiceRequest;
import cn.ocoop.framework.mybank.ServiceResponse;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 多银存资金调拨
 */
public class TradePayInstant {
    public static final String SERVICE = "mybank.tc.trade.pay.instant";

    @EqualsAndHashCode(callSuper = true)
    @Data
    @Builder
    @ToString(callSuper = true)
    public static class Request extends ServiceRequest<Response> {

        /**
         * 不可空
         * <p>
         * 合作方业务平台订单号
         * <p>
         * 合作方提交的交易号，对于合作方全局唯一
         * <p>
         * 2017032216593367523352596551
         */
        private String outer_trade_no;
        /**
         * 可空
         * <p>
         * 合作方平台自接入款渠道发起的支付，上送支付渠道的支付订单号。若为pay_method余额支付，则该栏位可空。该订单号编码规则银行不做要求，以合作方平台与入款渠道约定规则为准。
         * <p>
         * 20101018001052601340050
         */
        private String outer_inst_order_no;
        /**
         * 可空
         * <p>
         * 平台专属入款渠道编码，pay_method非余额支付方式时必填。该栏位的可选列表由网商银行小二根据平台递交的申请表分配并反馈。编码规则：入款渠道编码+5位序号。如：入款渠道为ALIPAY，网商分配反馈的编码则可以是ALIPAY00012，具体编码以小二反馈信息为准。
         * <p>
         * ALIPAY00012
         */
        private String white_channel_code;
        /**
         * 不可空
         * <p>
         * 买家在业务平台的ID（UID）。匿名支付场景下，此栏位填写anonymous
         * <p>
         * U500000001
         */
        private String buyer_id;
        /**
         * 可空
         * <p>
         * 用户在业务平台下单的时候的ip地址，公网IP，不是内网IP
         * <p>
         * 用于风控校验
         * <p>
         * 202.114.12.45
         */
        private String buyer_ip;
        /**
         * 不可空
         * <p>
         * 支付方式，格式为Json，具体说明见下方接口参数补充说明。
         * <p>
         * {"pay_method":"QPAY","amount":"0.3","memo":"ALIPAY,C,DC,   N6228480210599399511","extension":""}
         */
        private String pay_method;
        /**
         * 可空
         * <p>
         * 折扣支付方式，无折扣则该栏位无需填写。 格式为JsonList，具体说明见下方接口参数补充说明。
         * <p>
         * {discount_type:"allowancePay",instCode: "DISCOUNTPAY",amountInfo: "25.00"}]
         */
        private String discount_pay_method;
        /**
         * 可空
         * <p>
         * 手续费信息，无手续费则该栏位无需填写。说明：
         * <p>
         * 如果只收买家手续费则卖家不填，如：
         * <p>
         * {"buyerFee":"0.3"}
         * <p>
         * <p>
         * <p>
         * sellerFee:卖家手续费
         * <p>
         * buyerFee：买家手续费
         * <p>
         * {"sellerFee":"0.5","buyerFee":"0.3"}
         */
        private String fee_info;
        /**
         * 不可空
         * <p>
         * 商品的标题/交易标题/订单标题/订单关键字等。
         * <p>
         * 该参数最长为128个汉字。
         * <p>
         * 油漆
         */
        private String subject;
        /**
         * 不可空
         * <p>
         * 商品单价。单位为：RMB Yuan。取值范围为[0.01，1000000.00]，精确到小数点后两位。
         * <p>
         * 115.00
         */
        private double price;
        /**
         * 不可空
         * <p>
         * 商品的数量。
         * <p>
         * 2
         */
        private int quantity;
        /**
         * 不可空
         * <p>
         * 交易金额=（商品单价×商品数量）。卖家实际扣款和卖家实际收款金额计算规则请参考接口参数补充说明。
         * <p>
         * 230.00
         */
        private double total_amount;
        /**
         * 可空
         * <p>
         * 交易金额分润账号集，接口参数补充说明
         * <p>
         * [{"uid":"10012547853","account_type":"BASIC","account_identity":"","amount":"10.00","royalty_rule":""},{"uid":"10012685423","account_type":"BASIC","account_identity   ":"","amount":"10.00","royalty_rule":""}]
         */
        private String royalty_parameters;
        /**
         * 不可空
         * <p>
         * 卖家在业务平台的用户ID（UID）
         * <p>
         * 10004563451
         */
        private String seller_id;
        /**
         * 不可空
         * <p>
         * 卖家账户类型
         * <p>
         * BASIC
         */
        private String account_type;
        /**
         * 可空
         * <p>
         * 商品描述。对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加。
         * <p>
         * 白色墙面漆 5KG
         */
        private String body;
        /**
         * 可空
         * <p>
         * 商品展示URL。收银台页面上，商品展示的超链接。
         * <p>
         * http://www.custom.com/?product-9.html
         */
        private String show_url;
        /**
         * 不可空
         * <p>
         * 服务器异步通知页面路径。该接口同步只受理请求，交易见证平台订单成功后会主动通知商户业务平台里指定的页面http路径。对应异步通知的“交易状态变更通知”。
         * <p>
         * http://mas.test.custom.net/atinterface/receive_notify.htm
         */
        private String notify_url;
        /**
         * 可空
         * <p>
         * 具体交易发生的店铺名称
         * <p>
         * xxx官方旗舰店
         */
        private String shop_name;
        /**
         * 可空
         * <p>
         * 预留字段，不必填。
         */
        private String product_code;
        /**
         * 可空
         * <p>
         * 预留字段，不必填。
         */
        private String operator_id;
        /**
         * 可空
         * <p>
         * 预留字段，不必填。
         */
        private String return_url;
        /**
         * 可空
         * <p>
         * 预留字段，不必填
         */
        private String go_cashier;
        /**
         * 可空
         * <p>
         * 预留字段，不必填。
         */
        private String is_web_access;
        /**
         * 可空
         * <p>
         * 预留字段，不必填。
         */
        private String account_identity;
        /**
         * 可空
         * <p>
         * 预留字段，不必填。
         */
        private String expiration_time;
        /**
         * 可空
         * <p>
         * 预留字段，不必填。
         */
        private String submit_time;

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
