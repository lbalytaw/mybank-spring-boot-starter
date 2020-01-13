package cn.ocoop.framework.mybank.service.notify;

import lombok.Data;
import org.apache.commons.beanutils.PropertyUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;

@Data
public class NotifyRequest {
    /**
     * 通知ID
     * <p>
     * 通知的唯一标识
     * <p>
     * 不可空
     * <p>
     * 2bf30f9cc5c646f5acbdde31d91947df
     */
    private String notify_id;
    /**
     * 通知类型
     * <p>
     * 交易通知：
     * <p>
     * trade_status_sync
     * <p>
     * 转账通知：
     * <p>
     * transfer_status_sync
     * <p>
     * 子账户汇入：
     * <p>
     * remit_sync
     * <p>
     * 单笔提现：
     * <p>
     * withdrawal_status_sync
     * <p>
     * 不可空
     * <p>
     * trade_status_sync(交易状态同步)
     */
    private String notify_type;
    /**
     * 通知时间
     * <p>
     * 通知的发送时间，格式：
     * <p>
     * yyyyMMddHHmmss
     * <p>
     * 不可空
     * <p>
     * 20131101102030
     */
    private String notify_time;
    /**
     * 参数字符集编码
     * <p>
     * 和商户请求中的字符集编码一样
     * <p>
     * 不可空
     * <p>
     * UTF-8
     */
    private String charset;
    /**
     * 签名
     * <p>
     * String
     * <p>
     * 见签名机制
     * <p>
     * 不可空
     */
    private String sign;
    /**
     * 签名方式
     * <p>
     * String
     * <p>
     * RSA，必须大写
     * <p>
     * 不可空
     * <p>
     * RSA
     */
    private String sign_type;
    /**
     * 版本号
     * <p>
     * String
     * <p>
     * 接口版本号
     * <p>
     * 不可空
     * <p>
     * 2.0
     */
    private String version;
    /**
     * 产品编码
     * <p>
     * String
     * <p>
     * 预留字段
     * <p>
     * 可空
     */
    private String productCode;


    public static <T extends NotifyRequest> T parse(HttpServletRequest request, Class<T> requestClass) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        T requester = requestClass.newInstance();
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            String value = request.getParameter(name);
            PropertyUtils.setProperty(requester, name, value);
        }

        return requester;
    }
}
