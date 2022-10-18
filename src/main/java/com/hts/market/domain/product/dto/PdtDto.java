package com.hts.market.domain.product.dto;

import com.hts.market.domain.member.dto.AddressDto;
import com.hts.market.domain.member.dto.MemDto;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

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
        private Long pdtSellerNo;
        @NotNull
        private Long pdtAddressNo;
        @NotEmpty
        private String pdtName;
        @NotNull
        private Integer pdtPrice;
        private List<MultipartFile> images;
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
        private Long pdtSellerNo;
        private String pdtName;
        private String pdtDesc;
        private Integer pdtStatus;
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
        // 관심수
        private Integer favoriteCount;
        // 관심 체크
        private Boolean favoriteCheck;
        // 채팅수
        private Integer chatCount;
        // 채팅 체크
        private Boolean chatCheck;
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
        // 관심 체크
        private Boolean favoriteCheck;
        // 관심수
        private Integer favoriteCount;
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
        private MemDto.Member member;
        // 판매내역
        private List<PdtDto.ReadList> sellerList;
        // 카테고리목록
        private List<PdtDto.ReadList> cateList;

    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ListData{
        private Long pdtNo;
        @NotEmpty
        private String addressSi;
        @NotEmpty
        private String addressGu;
        @NotEmpty
        private String addressDong;
        @NotNull
        private Integer start;
        @NotNull
        private Integer end;
        private String keyword;
        private Long pdtCateNo;
        private String pdtCate;
        private Long pdtSellerNo;
    }

//    // 주소별 검색에 필요한 데이터
//    @Data
//    @Builder
//    @AllArgsConstructor
//    @NoArgsConstructor
//    public static class AddressData{
//        @NotNull
//        private long pdtNo;
//        @NotEmpty
//        private String addressSi;
//        @NotEmpty
//        private String addressGu;
//        @NotEmpty
//        private String addressDong;
//        @NotNull
//        private Integer start;
//        @NotNull
//        private Integer end;
//    }


    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ViewCount {
        private Long pdtNo;
        private Long memNo;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Profile{
        private Long pdtNo;
        private Long imgNo;
        private List<MultipartFile> image;
    }
}
