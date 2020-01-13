package cn.ocoop.framework.mybank.service.register;

import cn.ocoop.framework.mybank.ServiceRequest;
import cn.ocoop.framework.mybank.ServiceResponse;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

public class CompanyGet {
    public static final String SERVICE = "mybank.tc.user.enterprise.info.query";

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
        private String unified_scoial_credit_code;
        /**
         * 可空
         * <p>
         * 企业简介
         */
        private String summary;
    }
}
