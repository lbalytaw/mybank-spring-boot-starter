package cn.ocoop.framework.mybank.service.bankcard;

import cn.ocoop.framework.mybank.ServiceRequest;
import cn.ocoop.framework.mybank.ServiceResponse;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

public class BankCardBinQuery {
    public static final String SERVICE = "mybank.tc.user.cardbin.query";

    @EqualsAndHashCode(callSuper = true)
    @Data
    @Builder
    @ToString(callSuper = true)
    public static class Request extends ServiceRequest<Response> {

        /**
         * 不可空
         * <p>
         * 银行卡号
         * <p>
         * 8888888453427229
         */
        private String bank_account_no;

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
         * 银行卡id，银行卡在交易见证平台的绑卡id
         */
        private List<CardBinInfo> card_bin_info;

        @Data
        public static class CardBinInfo {
            /**
             * 不可空
             * <p>
             * 卡bin信息
             * <p>
             * 888888
             */
            private String card_bin;
            /**
             * 不可空
             * <p>
             * 卡类型
             * <p>
             * DC:借记卡，CC:贷记卡,SCC:准贷记卡
             */
            private String card_type;
            /**
             * 不可空
             * <p>
             * 机构联行号
             * <p>
             * 323331000001
             */
            private String branch_no;
            /**
             * 不可空
             * <p>
             * 所属银行名称
             * <p>
             * 浙江网商银行股份有限公司
             */
            private String bank_name;
        }
    }
}
