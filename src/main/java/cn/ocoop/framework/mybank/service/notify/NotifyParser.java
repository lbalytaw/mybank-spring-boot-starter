package cn.ocoop.framework.mybank.service.notify;

import lombok.experimental.UtilityClass;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

@UtilityClass
public class NotifyParser {

    public NotifyRequest parse(HttpServletRequest request) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        switch (request.getParameter("notify_type")) {
            case "trade_status_sync":
                return NotifyRequest.parse(request, NotifyRequestTradeStatusSync.class);
            case "transfer_status_sync":
                return NotifyRequest.parse(request, NotifyRequestTradeTransfer.class);
            case "remit_sync":
                return NotifyRequest.parse(request, NotifyRequestSubAccountIncome.class);
            case "withdrawal_status_sync":
                return NotifyRequest.parse(request, NotifyRequestWithdrawal.class);
            default:
                throw new UnsupportedOperationException("不支持此类型的通知");
        }
    }
}
