package cn.ocoop.framework.mybank.service.register;

import cn.ocoop.framework.mybank.ServiceRequest;
import cn.ocoop.framework.mybank.ServiceResponse;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

public class PersonalGet {
    public static final String SERVICE = "mybank.tc.user.personal.info.query";

    @EqualsAndHashCode(callSuper = true)
    @Data
    @Builder
    @ToString(callSuper = true)
    public static class Request extends ServiceRequest<Response> {

        /**
         * 不可空
         * <p>
         * 合作方业务平台用户ID
         * <p>
         * 100000795683
         */
        private String Uid;


        @Override
        public String getService() {
            return SERVICE;
        }

    }


    @EqualsAndHashCode(callSuper = true)
    @Data
    @ToString(callSuper = true)
    public static class Response extends ServiceResponse {

        /**
         * 合作方业务平台用户ID
         * <p>
         * 100000795683
         */
        private String Uid;
        /**
         * 手机号
         * <p>
         * 13906889493
         */
        private String Mobile;
        /**
         * 邮箱号
         * <p>
         * example@example.com
         */
        private String Email;
        /**
         * 真实姓名
         */
        private String real_name;
        /**
         * 用户昵称(平台个人会员登录名)
         */
        private String member_name;
        /**
         * 证件类型，见4.2附录证件类型
         */
        private String certificate_type;
        /**
         * 作为会员实名认证通过后的身份证号
         */
        private String certificate_no;
        /**
         * 会员Id
         */
        private String member_id;
    }
}
