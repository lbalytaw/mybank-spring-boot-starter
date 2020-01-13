package cn.ocoop.framework.mybank.service.register;

import cn.ocoop.framework.mybank.ServiceRequest;
import cn.ocoop.framework.mybank.ServiceResponse;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

public class CompanyModify {
    public static final String SERVICE = "mybank.tc.user.enterprise.info.modify";

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
         * 企业名称
         */
        private String enterprise_name;
        /**
         * 可空
         * <p>
         * 企业简称
         */
        private String member_name;
        /**
         * 可空
         * <p>
         * 企业法人姓名
         */
        private String legal_person;
        /**
         * 可空
         * <p>
         * 法人手机号码
         * <p>
         * 13812345600
         */
        private String legal_person_phone;
        /**
         * 可空
         * <p>
         * 法人证件类型
         * <p>
         * 见附录4.2证件类型
         */
        private String legal_person_certificate_type;
        /**
         * 可空
         * <p>
         * 法人证件号
         */
        private String legal_person_certificate_no;
        /**
         * 可空
         * <p>
         * 企业网址
         */
        private String website;
        /**
         * 可空
         * <p>
         * 企业地址
         */
        private String address;
        /**
         * 可空
         * <p>
         * 执照号,若营业执照号和统一社会信用代码都填写，则取统一社会信用代码
         * <p>
         * 若做企业实名认证则不可空
         */
        private String license_no;
        /**
         * 可空
         * <p>
         * 营业执照所在地
         */
        private String license_address;
        /**
         * 可空
         * <p>
         * 执照过期日（营业期限）yyyymmdd
         * <p>
         * 20100131
         */
        private String license_expire_date;
        /**
         * 可空
         * <p>
         * 营业范围
         */
        private String business_scope;
        /**
         * 可空
         * <p>
         * 联系电话
         */
        private String telephone;
        /**
         * 可空
         * <p>
         * 组织机构代码
         */
        private String organization_no;
        /**
         * 可空
         * <p>
         * 统一社会信用代码
         * <p>
         * 若做企业实名认证则不可空
         */
        private String open_account_license;
        /**
         * 可空
         * <p>
         * 统一社会信用代码
         * <p>
         * 若做企业实名认证则不可空
         */
        private String unified_social_credit_code;
        /**
         * 可空
         * <p>
         * 企业简介
         */
        private String summary;

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
