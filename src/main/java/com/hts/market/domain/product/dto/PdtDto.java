package com.hts.market.domain.product.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PdtDto {
    @Data
    public static class Create {
        private String pdtName;
        private long pdtCateNo;
        private Integer pdtPrice;
        private String pdtDesc;
        private String pdtStatus;
    }

    @Data
    public static class Update {
        private long pdtNo;
        private String pdtName;
        private long pdtCateNo;
        private Integer pdtPrice;
        private String pdtDesc;
        private String pdtStatus;
    }

    @Data
    public static class Page {
        private String pdtName;
        private LocalDateTime pdtCreatedAt;
        private Integer pdtPrice;
        private Integer pdtViews;
        private long pdtAdressNo;
        private Integer pdtStatus;
    }

    @Data
    public static class Read {
        private String pdtName;
        private LocalDateTime pdtCreatedAt;
        private Integer pdtPrice;
        private Integer pdtViews;
        private long pdtAdressNo;
        private String pdtDesc;
        private long pdtSellerNo;
        private Integer pdtStatus;
    }

    @Data
    public static class KeywordRead{
        private String seller;
        private String title;
    }
}
