package cn.ocoop.framework.mybank.service.notify;

public class NotifyTest {
    public static void main(String[] args) throws Exception {
        notify1();
    }

    private static void notify1() throws Exception {
        NotifyMock.Response x = NotifyMock.Request.builder()
                .payer_card_no("20131105154925")
                .payer_card_name("张三")
                .payee_card_no("5845342722900597914")
                .payee_card_name("新增企业八")
                .amount(1000000000000L)
                .payer_remark("汇款")
                .notify_url("https://u.ngrok2.xiaomiqiu.cn")
                .build().exec();
        System.out.println(x);
    }
}
