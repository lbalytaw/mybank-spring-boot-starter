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
public class TradeRealTransfer {
    public static final String SERVICE = "mybank.tc.trade.realtransfer";

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
         * 合作方对接出款渠道使用的提现订单号。若出款渠道是网商银行，则此处填写与outer_trade_no保持一致。
         * <p>
         * 20101018001052601340052
         */
        private String outer_inst_order_no;
        /**
         * 不可空
         * <p>
         * 平台专属出款渠道编码，该栏位的可选列表由网商银行小二根据平台递交的申请表分配并反馈。编码规则：出款渠道编码+5位序号。如：出款渠道为网商，网商分配反馈的编码则可以是MYBKFT00001，具体编码以小二反馈信息为准。
         * <p>
         * MYBKFT00001
         */
        private String white_channel_code;
        /**
         * 不可空
         * <p>
         * 转入网商银行账号
         * <p>
         * 888888123659856
         */
        private String fundin_mybank_no;
        /**
         * 不可空
         * <p>
         * 转出网商银行账号
         * <p>
         * 888888158659856
         */
        private String fundout_mybank_no;
        /**
         * 不可空
         * <p>
         * 调拨金额。金额必须小于等于账户可用余额 ，单位：元
         * <p>
         * 15.00
         */
        private double transfer_amount;
        /**
         * 不可空
         * <p>
         * 服务器异步通知页面路径。
         * <p>
         * 对应异步通知的“调拨状态变更通知”
         * <p>
         * http://biz/atinterface/receive_notify.htm
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
