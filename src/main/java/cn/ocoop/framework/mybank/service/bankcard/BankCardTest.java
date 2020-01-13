package cn.ocoop.framework.mybank.service.bankcard;

public class BankCardTest {
    public static void main(String[] args) throws Exception {
//        unbind();
//        get();
        bin();
    }

    private static void bin() throws Exception {
        BankCardBinQuery.Response x = BankCardBinQuery.Request.builder()
                .bank_account_no("6214832506543649")
                .build().exec();
        System.out.println(x);
    }

    private static void bind() throws Exception {
        BankCardBind.Response x = BankCardBind.Request.builder()
                .uid("w02")
                .bank_name("中国工商银行")
                .bank_account_no("6225885425698746")
                .account_name("测试用户")
                .card_type("DC")
                .card_attribute("C")
                .verify_type("4")
                .certificate_type("ID_CARD")
                .certificate_no("32132319000238994")
                .reserved_mobile("17301597660")
                .build().exec();
        System.out.println(x);
    }

    private static void unbind() throws Exception {
        BankCardUnbind.Response x = BankCardUnbind.Request.builder()
                .uid("w02")
                .bank_id("12426")
                .build().exec();
        System.out.println(x);
    }

    private static void get() throws Exception {
        BankCardQuery.Response x = BankCardQuery.Request.builder()
                .uid("w02")
                .build().exec();
        System.out.println(x);
    }

}
