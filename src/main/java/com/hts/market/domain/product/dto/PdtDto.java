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
        private String desc;
        private String title;
    }

    // 판매자 검색, 카테고리 검색은 변수1개로 DTO 안만듬
}
