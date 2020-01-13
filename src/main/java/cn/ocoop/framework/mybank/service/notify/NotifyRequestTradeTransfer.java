package cn.ocoop.framework.mybank.service.notify;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 转账交易处理结果通知
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class NotifyRequestTradeTransfer extends NotifyRequest {
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
     * TRADE_FINISHED 转账成功
     * <p>
     * TRADE_FAILED  转账失败
     * <p>
     * 不可空
     * <p>
     * TRADE_FINISHED
     */
    private String transfer_status;
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


}
