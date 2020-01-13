package cn.ocoop.framework.mybank.service.register;

public class CompanyTest {
    public static void main(String[] args) throws Exception {
        companyRegister();
//        companyGet();
//        companyModify();
//        companyGet();
    }

    private static void companyRegister() throws Exception {
        CompanyRegister.Response x = CompanyRegister.Request.builder()
                .uid("w02")
                .enterprise_name("江苏我可网")
                .member_name("我可网")
                .unified_social_credit_code("91320100MA1WB5YQ03")
                .is_verify("Y")
                .build().exec();
        System.out.println(x);
    }

    private static void companyGet() throws Exception {
        CompanyGet.Response x = CompanyGet.Request.builder()
                .Uid("w02")
                .build().exec();
        System.out.println(x);
    }

    private static void companyModify() throws Exception {
        CompanyModify.Response x = CompanyModify.Request.builder()
                .uid("w02")
                .enterprise_name("修改后的企业名称")
                .member_name("修改后的会员名称")
                .unified_social_credit_code("91320100MA1WB5YQ03")
                .is_verify("Y")
                .build().exec();
        System.out.println(x);
    }

}
