package cn.ocoop.framework.mybank.service.notify;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 单笔提现结果异步通知
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class NotifyRequestWithdrawal extends NotifyRequest {
    /**
     * 商户网站提现唯一订单号
     * <p>
     * String(32)
     * <p>
     * 标识商户提现订单的唯一凭证号，失败后再发起需要更换
     * <p>
     * 不可空
     * <p>
     * 29388034012938822409
     */
    private String outer_trade_no;
    /**
     * 交易见证平台交易号
     * <p>
     * String(32)
     * <p>
     * 提现交易订单号
     * <p>
     * 可空
     */
    private String inner_trade_no;
    /**
     * 提现金额
     * <p>
     * Number
     * <p>
     * 提现金额，单位为RMB-Yuan，精确到小数点后两位
     * <p>
     * 可空
     */
    private String withdrawal_amount;
    /**
     * 提现状态
     * <p>
     * String
     * <p>
     * TRADE_FINISHED 提现成功
     * <p>
     * TRADE_FAILED 提现失败
     * <p>
     * WITHDRAWAL_SUBMITTED  已受理（此状态为提现通知状态）
     * <p>
     * REFUND_TICKET 退票成功
     * <p>
     * 不可空
     * <p>
     * TRADE_FINISHED
     */
    private String withdrawal_status;
    /**
     * 错误代码
     * <p>
     * String(10)
     * <p>
     * 失败时指出具体原因
     * 可空
     */
    private String error_code;
    /**
     * 错误信息
     * <p>
     * String(500)
     * <p>
     * 提现失败原因
     * 可空
     */
    private String error_msg;
    /**
     * 交易处理完成时间
     * <p>
     * String
     * <p>
     * 格式：
     * <p>
     * yyyyMMddHHmmss
     * <p>
     * 不可空
     */
    private String gmt_close;
    /**
     * 用户ID
     * <p>
     * String
     * <p>
     * 合作方业务平台用户ID
     * <p>
     * 不可空
     */
    private String uid;
    /**
     * 账户类型
     * <p>
     * String(5)
     * <p>
     * 账户类型
     * <p>
     * 不可空
     * <p>
     * BASIC
     */
    private String account_type;
    /**
     * 账户标识
     * <p>
     * String(32)
     * <p>
     * 预留字段，可不填
     * <p>
     * 可空
     */
    private String account_identity;
}
