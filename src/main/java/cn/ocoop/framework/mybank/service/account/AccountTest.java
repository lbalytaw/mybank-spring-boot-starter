package cn.ocoop.framework.mybank.service.account;

public class AccountTest {
    public static void main(String[] args) throws Exception {
        accountCreate();
//        accountBalance1();
//        accountBalance();
    }

    private static void accountCreate() throws Exception {
        AccountCreate.Response x = AccountCreate.Request.builder()
                .uid("w02")
                .account_type("DEPOSIT")
                .alias("保证金账户")
                .build().exec();
        System.out.println(x);
    }

//    private static void accountBalance() throws Exception {
//        Map<String, String> request = AccountBalanceGet.Request.builder()
//                .uid("w02")
//                .account_type("DEPOSIT")
//                .build().buildRequest("test");
//        String post = HttpUtils.post(request, String.class);
//        AccountBalanceGet.Response x = ServiceResponse.valueOf(post, AccountBalanceGet.Response.class);
//        System.out.println(x);
//    }
//
//    private static void accountBalance1() throws Exception {
//        Map<String, String> request = AccountBalanceGet.Request.builder()
//                .uid("WKW01")
//                .account_type("BASIC")
//                .build().buildRequest("test");
//        String post = HttpUtils.post(request, String.class);
//        AccountBalanceGet.Response x = ServiceResponse.valueOf(post, AccountBalanceGet.Response.class);
//        System.out.println(x);
//    }
}
