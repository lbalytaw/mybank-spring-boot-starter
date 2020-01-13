package cn.ocoop.framework.mybank.service.register;

public class PersonalTest {
    public static void main(String[] args) throws Exception {
        personalRegister();
//        personalGet();

//        personalModify();
//        personalGet();
    }

    private static void personalRegister() throws Exception {
        PersonalRegister.Response x = PersonalRegister.Request.builder()
                .uid("WKW01")
                .mobile("17301597660")
                .member_name("张桂芳")
                .certificate_type("ID_CARD")
                .certificate_no("340827199303024740")
                .real_name("张意义")
                .is_verify("Y")
                .build().exec();
        System.out.println(x);
    }

    private static void personalGet() throws Exception {
        PersonalGet.Response x = PersonalGet.Request.builder()
                .Uid("WKW01")
                .build().exec();
        System.out.println(x);
    }

    private static void personalModify() throws Exception {
        PersonalModify.Response x = PersonalModify.Request.builder()
                .uid("WKW01")
                .mobile("17301597660")
                .member_name("修改后的memberName")
                .certificate_type("ID_CARD")
                .certificate_no("340827199303024740")
                .real_name("哈哈")
                .is_verify("Y")
                .build().exec();
        System.out.println(x);
    }


}
