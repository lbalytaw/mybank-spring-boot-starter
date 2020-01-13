package cn.ocoop.framework.mybank.service.trade;

import org.apache.commons.lang3.RandomUtils;

public class TradeTest {
    public static void main(String[] args) throws Exception {
//        pay2Card();
//        refundTicket();
//        realTransfer();
        tradeTransfer();
//        tradeQuery();
    }

    private static void pay2Card() throws Exception {
        TradePay2Card.Response x = TradePay2Card.Request.builder()
                .outer_trade_no("t01")
                .uid("w02")
                .outer_inst_order_no("w1")
                .white_channel_code("MYBANK00012")
                .account_type("BASIC")
                .bank_id("12427")
                .amount(15000.00)
                .bank_account_no("6225885425698746")
                .notify_url("http://biz/atinterface/receive_notify.htm")
                .build().exec();
        System.out.println(x);
    }

    private static void refundTicket() throws Exception {
        TradeRefundTicket.Response x = TradeRefundTicket.Request.builder()
                .request_no("0")
                .orig_outer_inst_order_no("w1")
                .build().exec();
        System.out.println(x);
    }

    private static void realTransfer() throws Exception {
        TradeRealTransfer.Response x = TradeRealTransfer.Request.builder()
                .outer_trade_no("wr0")
                .outer_inst_order_no("wr0")
                .white_channel_code("MYBANK00012")
                .fundin_mybank_no("888888123659856")
                .fundout_mybank_no("888888158659856")
                .transfer_amount(15.00)
                .notify_url("http://biz/atinterface/receive_notify.htm")
                .build().exec();
        System.out.println(x);
    }

    private static void tradeTransfer() throws Exception {
        //网商划款:BASIC账户->担保账户
        TradeTransfer.Response x = TradeTransfer.Request.builder()
                .outer_trade_no(String.valueOf(RandomUtils.nextLong()))
                .fundin_uid("WKW01")
                .fundin_account_type("BASIC")
                .fundout_uid("w02")
                .fundout_account_type("DEPOSIT")
                .transfer_amount(9999999.0)
                .notify_url("")
                .build().exec();
        System.out.println(x);

    }

    private static void tradeQuery() throws Exception {
        //网商划款:BASIC账户->担保账户
        TradeQuery.Response x = TradeQuery.Request.builder()
                .outer_trade_no("w01")
                .build().exec();
        System.out.println(x);
    }


}
