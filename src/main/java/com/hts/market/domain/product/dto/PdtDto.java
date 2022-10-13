package com.hts.market.domain.product.dto;

import com.hts.market.domain.member.dto.AddressDto;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

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
        @NotNull
        private Long pdtNo;
        private Long pdtCateNo;
        private Long pdtAddressNo;
        private String pdtName;
        private Integer pdtStatus;
        private String pdtDesc;
        private Integer pdtPrice;

    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Delete{
        @NotNull
        private Long pdtNo;
        @NotNull
        private Long pdtSellerNo;
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
        @NotEmpty
        private String addressSi;
        @NotEmpty
        private String addressGu;
        @NotEmpty
        private String addressDong;
        @NotNull
        private Integer start = 1;
        @NotNull
        private Integer end = 10;
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
//        private String addressSi;
//        private String addressGu;
//        private String addressDong;
        // product_image 에서 가져온 값
//        private List<PdtImgDto.Read> imgList;
//        // product_category 에서 가져온 값
//        private String pdtCate;
        // member
    }
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Detail {
        private PdtDto.Read product;
        private AddressDto.Read address;
        private List<PdtImgDto.Read> images;
        // product_category 에서 가져온 값
        private String pdtCate;
        // member
//        private MemDto.Membermember;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SearchData{
        private String addressSi;
        private String addressGu;
        private String addressDong;
        private Integer start = 1;
        private Integer end = 10;
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
        private Long memNo;
    }
}
