package cn.ocoop.framework.mybank.service.account;

import cn.ocoop.framework.mybank.ServiceRequest;
import cn.ocoop.framework.mybank.ServiceResponse;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

public class AccountCreate {
    public static final String SERVICE = "mybank.tc.user.account.create";

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
         * 账户类型
         * <p>
         * DEPOSIT
         */
        private String account_type;
        /**
         * 不可空
         * <p>
         * 账户别名
         * <p>
         * 保证金户
         */
        private String alias;
        /**
         * 可空
         * <p>
         * 不必填
         */
        private String account_identity;

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
         * 不可空
         * <p>
         * 会员账户号
         * <p>
         * 200100100210000369876500001
         */
        private String account_id;
        /**
         * 不可空
         * <p>
         * 账户创建时间
         * <p>
         * 2015-07-09   17:46:42
         */
        private String create_time;
    }
}
