package cn.ocoop.framework.mybank.service.notify;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 子账号汇入结果通知
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class NotifyRequestSubAccountIncome extends NotifyRequest {
    /**
     * 商户订单号
     * <p>
     * String(38)
     * <p>
     * 标识商户交易订单的唯一凭证号
     * <p>
     * 不可空
     * <p>
     * 29388034012938822409
     */
    private String outer_trade_no;
    /**
     * 子账户号
     * <p>
     * String(32)
     * <p>
     * 子账户
     * <p>
     * 不可空
     */
    private String subAccount;
    /**
     * 子账户名称
     * <p>
     * String(64)
     * <p>
     * 子账号名
     * <p>
     * 不可空
     */
    private String subAccountName;
    /**
     * 金额
     * <p>
     * Number(15)
     * <p>
     * 金额
     * <p>
     * 不可空
     * <p>
     * 15000.00
     */
    private String remitAmount;
    /**
     * 交易状态
     * <p>
     * String(20)
     * <p>
     * SUCCESS成功
     * <p>
     * ON_ACCOUNT已挂账CANCEL_SUCCESS 已销账
     * <p>
     * 不可空
     * <p>
     * SUCCESS
     */
    private String status;
    /**
     * 产品码
     * <p>
     * String(20)
     * <p>
     * 产品码 10102
     * <p>
     * 可空
     * <p>
     * 10102
     */
    private String productCode;
    /**
     * 渠道Id
     * <p>
     * String(16)
     * <p>
     * 9001大额、9002小额、9003超网、9100支付宝
     * <p>
     * 不可空
     */
    private String chnlId;
    /**
     * 扩展信息
     * <p>
     * String(512)
     * <p>
     * <p>
     * 可空
     */
    private String extInfo;
    /**
     * 收款方户名
     * <p>
     * String(256)
     * <p>
     * xxx有限公司
     * <p>
     * 不可空
     */
    private String payeeCardName;
    /**
     * 收款方卡号
     * <p>
     * String(32)
     * <p>
     * <p>
     * 不可空
     */
    private String payeeCardNo;
    /**
     * 付款方联行号
     * <p>
     * String(32)
     * <p>
     * <p>
     * 不可空
     */
    private String payerBankOrgId;
    /**
     * 付款方户名
     * <p>
     * String(256)
     * <p>
     * <p>
     * 不可空
     */
    private String payerCardName;
    /**
     * 付款方卡号
     * <p>
     * String(32)
     * <p>
     * <p>
     * 不可空
     */
    private String payerCardNo;
    /**
     * 付款方备注
     * <p>
     * String(256)
     * <p>
     * <p>
     * 可空
     */
    private String payerRemark;
    /**
     * 流水号
     * <p>
     * String(64)
     * <p>
     * <p>
     * 不可空
     */
    private String txId;
    /**
     * 请求时间
     * <p>
     * Date
     * <p>
     * 请求创建时间，格式：
     * <p>
     * yyyyMMddHHmmss
     * <p>
     * 可空
     * <p>
     * 20171101102030
     */
    private String gmt_create;

}
