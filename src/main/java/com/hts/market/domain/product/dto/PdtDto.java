package com.hts.market.domain.product.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PdtDto {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create {
        private Long pdtCateNo;
        @NotEmpty
        private String pdtName;
        @NotNull
        private Integer pdtPrice;
        @NotEmpty
        private String pdtDesc;
        @NotEmpty
        private String pdtStatus;
        private Long pdtAddressNo;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Update {
        private Long pdtNo;
        private Long pdtCateNo;
        @NotEmpty
        private String pdtName;
        @NotNull
        private Integer pdtPrice;
        @NotEmpty
        private String pdtDesc;
        @NotEmpty
        private String pdtStatus;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Delete{
        private Long pdtNo;
        private Long memNo;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Page {
        private long pdtNo;
        private String pdtName;
        private LocalDateTime pdtCreatedAt;
        private Integer pdtPrice;
        private Integer pdtViews;
        private Long pdtAddressNo;
        private Integer pdtStatus;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Read {
        private String pdtName;
        private LocalDateTime pdtCreatedAt;
        private Integer pdtPrice;
        private Integer pdtViews;
        private Long pdtAddressNo;
        private String pdtDesc;
        private Long pdtSellerNo;
        private Integer pdtStatus;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class KeywordSearch{
        private long pdtNo;
        private String pdtDesc;
        private String pdtName;
    }


    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CateSearch{
        private long pdtCateNo;
        private String pdtCate;
    }
}
