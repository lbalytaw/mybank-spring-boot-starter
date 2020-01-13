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
public class TradeTransfer {
    public static final String SERVICE = "mybank.tc.trade.transfer";

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
         * 30000043551252390
         */
        private String outer_trade_no;
        /**
         * 不可空
         * <p>
         * 入款用户Id,金额增加方的用户ID（UID）或会员ID（内部会员ID）
         * <p>
         * U50000001
         */
        private String fundin_uid;
        /**
         * 不可空
         * <p>
         * 入款账户类型。金额增加的账户的账户类型
         * <p>
         * BASIC
         */
        private String fundin_account_type;
        /**
         * 不可空
         * <p>
         * 用户Id,金额减少方的用户ID（UID），或会员ID（内部会员ID）
         * <p>
         * U50000001
         */
        private String fundout_uid;
        /**
         * 不可空
         * <p>
         * 账户类型,金额减少的账户的账户类型
         * <p>
         * BASIC
         */
        private String fundout_account_type;
        /**
         * 转账金额。必须大于0
         * <p>
         * 210.00
         */
        private double transfer_amount;
        /**
         * 服务器异步通知页面路径。支付平台服务器主动通知业务平台里指定的页面http路径。
         * <p>
         * 对应异步通知的“交易处理结果通知”
         * <p>
         * http://biz/atinterface/receive_notify.htm
         */
        private String notify_url;
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
        private String transfer_type;
        /**
         * 预留字段，不必填（金额减少的账户的账户标识）
         */
        private String fundout_account_identity;
        /**
         * 预留字段，不必填（金额增加的账户的账户标识）
         */
        private String fundin_account_identity;
        /**
         * 可空
         * <p>
         * 预留字段，不必填
         */
        private String product_code;

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
