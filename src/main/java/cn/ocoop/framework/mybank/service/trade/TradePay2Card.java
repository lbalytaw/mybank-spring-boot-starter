package cn.ocoop.framework.mybank.service.trade;

import cn.ocoop.framework.mybank.ServiceRequest;
import cn.ocoop.framework.mybank.ServiceResponse;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

public class TradePay2Card {
    public static final String SERVICE = "mybank.tc.trade.paytocard";

    @EqualsAndHashCode(callSuper = true)
    @Data
    @Builder
    @ToString(callSuper = true)
    public static class Request extends ServiceRequest<Response> {

        /**
         * 不可空
         * <p>
         * 合作方业务平台订单号
         * 合作方提交的交易号，对于合作方全局唯一
         * <p>
         * 20101018001052601340052
         */
        private String outer_trade_no;
        /**
         * 不可空
         * <p>
         * 合作方业务平台用户ID
         * <p>
         * U500000001
         */
        private String uid;
        /**
         * 不可空
         * <p>
         * 合作方对接出款渠道使用的提现订单号。若出款渠道是网商银行，则此处填写与outer_trade_no保持一致。
         * <p>
         * 20101018001052601340052
         */
        private String outer_inst_order_no;
        /**
         * 不可空
         * <p>
         * 平台专属出款渠道编码，该栏位的可选列表由网商银行小二根据平台递交的申请表分配并反馈。编码规则：出款渠道编码+5位序号。如：出款渠道为网商，网商分配反馈的编码则可以是MYBANK00012，具体编码以小二反馈信息为准。
         * <p>
         * MYBANK00012
         */
        private String white_channel_code;
        /**
         * 不可空
         * <p>
         * 账户类型,会员提现
         * <p>
         * 不支持平台方账户类型提现。
         * <p>
         * BASIC
         */
        private String account_type;
        /**
         * 不可空
         * <p>
         * 会员在交易见证平台绑定绑卡id，即10401绑银行卡接口或者10404绑支付宝接口返回的bank_id。
         */
        private String bank_id;
        /**
         * 不可空
         * <p>
         * 提现金额。金额必须不大于账户可用余额
         * <p>
         * 15000.00
         */
        private double amount;
        /**
         * 不可空
         * <p>
         * 服务器异步通知页面路径。
         * <p>
         * 对应异步通知的“提现状态变更通知（单笔）”
         * <p>
         * http://biz/atinterface/receive_notify.htm
         */
        private String notify_url;
        /**
         * 可空
         * <p>
         * 手续费信息，json格式。buyerFee即
         * <p>
         * 收取会员提现手续费。
         * <p>
         * {"buyerFee":"0.3"}
         */
        private String fee_info;
        /**
         * 可空
         * <p>
         * 预留字段，不必填
         */
        private String is_web_access;
        /**
         * 可空
         * <p>
         * 预留字段，不必填
         */
        private String account_identity;
        /**
         * 可空
         * <p>
         * 预留字段，不必填
         */
        private String product_code;
        /**
         * 可空
         * <p>
         * 预留字段，不必填
         */
        private String bank_account_no;
        /**
         * 可空
         * <p>
         * 预留字段，不必填
         * <p>
         * NORMAL普通卡
         * <p>
         * QPAY快捷
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
    }
}
