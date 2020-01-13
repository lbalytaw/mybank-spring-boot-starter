package cn.ocoop.framework.mybank.service.notify;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 入账交易处理结果通知/退款交易处理结果通知
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class NotifyRequestTradeStatusSync extends NotifyRequest {
    /**
     * 商户网站唯一订单号
     * <p>
     * String(32)
     * <p>
     * 合作方业务平台唯一订单号
     * <p>
     * 不可空
     * <p>
     * 2015070609402382115027336039
     */
    private String outer_trade_no;
    /**
     * 支付系统交易号
     * <p>
     * String(64)
     * <p>
     * 交易凭证号
     * <p>
     * 不可空
     * <p>
     * 101143651423149320100
     */
    private String inner_trade_no;
    /**
     * 交易处理完成时间
     * <p>
     * String
     * <p>
     * 交易处理完成时间，交易状态为：TRADE_FINISHED时才有值，格式：
     * <p>
     * yyyyMMddHHmmss
     * <p>
     * 商户平台需要落地该时间，作为与云资金管理平台的对账时间
     * <p>
     * 不可空
     * <p>
     * 20131101102030
     */
    private String gmt_close;
    /**
     * 交易状态
     * <p>
     * String(20)
     * <p>
     * TRADE_SUCCESS  即时到账/充值交易成功
     * <p>
     * TRADE_FINISHED     即时到账/充值交易交易结束
     * <p>
     * TRADE_FAILED  即时到账/充值交易失败
     * <p>
     * REFUND_FINISH 退款成功
     * <p>
     * REFUND_FAILED 退款失败
     * <p>
     * 不可空
     * <p>
     * TRADE_FINISHED
     * <p>
     * <p>
     * TRADE_CLOSED  担保交易关闭
     */
    private String trade_status;
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
     * 交易金额
     * <p>
     * Number
     * <p>
     * 交易金额，单位为RMB-Yuan，精确到小数点后两位
     * <p>
     * 不可空
     * <p>
     * 998.00
     */
    private String trade_amount;
}
