package com.hts.market.domain.product.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Collection;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PdtDto {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create {
        private Long pdtNo;
        @NotNull
        private Long pdtCateNo;
        @NotNull
        private Long pdtSellerNo;
        @NotNull
        private Long pdtAddressNo;
        @NotEmpty
        private String pdtName;
        @NotNull
        private Integer pdtStatus;
        @NotEmpty
        private String pdtDesc;
        @NotNull
        private Integer pdtPrice;

    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Update {
        private Long pdtNo;
        @NotNull
        private Long pdtCateNo;
        @NotNull
        private Long pdtAddressNo;
        @NotEmpty
        private String pdtName;
        @NotNull
        private Integer pdtStatus;
        @NotEmpty
        private String pdtDesc;
        @NotNull
        private Integer pdtPrice;

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
    public static class ReadList{
        private Long pdtNo;
        private String pdtCate;
        private String pdtName;
        private Integer pdtStatus;
        private Integer pdtPrice;
        private Integer pdtViews;
        private LocalDateTime pdtCreatedAt;
        private String imgPath;
        private String addressSi;
        private String addressGu;
        private String addressDong;
    }

    // 주소별 검색에 필요한 데이터
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AddressData{
        private String addressSi;
        private String addressGu;
        private String addressDong;
        private Integer start;
        private Integer end;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Page{
        private Long pageNo;
        private Integer pageSize;
        private Long totalNo;
        private Collection<ReadList> pdtList;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Read {
        private Long pdtNo;
        private Long pdtSellerNo;
        private String pdtName;
        private String pdtDesc;
        private Integer pdtStatus;
        private Integer pdtPrice;
        private Integer pdtViews;
        private LocalDateTime pdtCreatedAt;
        // address 에서 가져온 값
        private String addressSi;
        private String addressGu;
        private String addressDong;
        // product_image 에서 가져온 값
        private String imgPath;
        // product_category 에서 가져온 값
        private String pdt_cate;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SearchData{
        private String addressSi;
        private String addressGu;
        private String addressDong;
        private Integer start;
        private Integer end;
        private String pdtName;
        private String pdtDesc;
        private Long pdtCateNo;
        private String pdtCate;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ViewCount {
        private Long pdtNo;
        private Long pdtSellerNo;
    }
}
