package cn.ocoop.framework.mybank.service.register;

import cn.ocoop.framework.mybank.ServiceRequest;
import cn.ocoop.framework.mybank.ServiceResponse;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

public class PersonalModify {
    public static final String SERVICE = "mybank.tc.user.personal.info.modify";

    @EqualsAndHashCode(callSuper = true)
    @Data
    @Builder
    @ToString(callSuper = true)
    public static class Request extends ServiceRequest<Response> {

        /**
         * 不可空
         * <p>
         * uid为合作方业务平台自定义，字母或数字，不能重复，不建议使用手机号作为uid。重复提交的开户请求根据uid 作幂等返回成功。接口若调用超时，平台可重新使用相同uid重复提交
         */
        private String uid;
        /**
         * 不可空
         * <p>
         * 真实姓名
         */
        private String real_name;
        /**
         * 不可空
         * <p>
         * 会员名称。用户昵称(平台个人会员登录名)
         */
        private String member_name;
        /**
         * 不可空
         * <p>
         * 见附录4.2证件类型
         * <p>
         * 目前个人会员只支持身份证。
         */
        private String certificate_type;

        /**
         * 不可空
         * <p>
         * 作为会员实名认证通过后的证件号
         */
        private String certificate_no;
        /**
         * 可空
         * <p>
         * 合作方业务平台用户手机号
         */
        private String mobile;
        /**
         * 可空
         * <p>
         * 邮箱号。
         */
        private String email;
        /**
         * 可空
         * <p>
         * 是否认证
         * <p>
         * Y:是   N:否
         */
        private String is_verify;


        @Override
        public String getService() {
            return SERVICE;
        }

    }


    @EqualsAndHashCode(callSuper = true)
    @Data
    @ToString(callSuper = true)
    public static class Response extends ServiceResponse {
    }
}
