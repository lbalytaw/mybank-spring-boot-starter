package cn.ocoop.framework.mybank;

import lombok.Data;

@Data
public class ServiceResponse {
    /**
     * 不可空
     * <p>
     * 成功标识。表示接口调用是否成功，并不表明业务处理结果。
     * <p>
     * T
     */
    private String is_success;
    /**
     * 不可空
     * <p>
     * 参数编码字符集。业务平台使用的编码格式，如utf-8、gbk、gb2312等
     * <p>
     * GBK
     */
    private String charset;
    /**
     * 可空
     * <p>
     * 返回错误码参见4.1附录
     * <p>
     * PARTNER_ID_NOT_EXIST
     */
    private String error_code;
    /**
     * 可空
     * <p>
     * 返回错误原因参见4.1附录
     * <p>
     * 合作方Id不存在
     */
    private String error_message;
    /**
     * 可空
     * <p>
     * 说明信息
     */
    private String memo;

    public boolean success() {
        return "T".equals(is_success);
    }
}
