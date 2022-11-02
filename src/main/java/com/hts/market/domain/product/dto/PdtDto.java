package com.hts.market.domain.product.dto;

import com.hts.market.domain.member.dto.AddressDto;
import com.hts.market.domain.member.dto.MemDto;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PdtDto {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create {
        private Long pdtNo;
        private Long pdtSellerNo;
        @NotNull private Long pdtCateNo;
        @NotEmpty private String pdtName;
        @NotEmpty private String pdtDesc;
        @NotNull private Integer pdtPrice;
        @NotEmpty private List<MultipartFile> images;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Update {
        @NotNull private Long pdtNo;
        private Long pdtSellerNo;
        @NotNull private Long pdtCateNo;
        private Long pdtAddressNo;
        @NotEmpty private String pdtName;
        @NotEmpty private String pdtDesc;
        @NotNull private Integer pdtPrice;
        private Integer pdtStatus;
        private List<MultipartFile> images;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Delete {
        @NotNull private Long pdtNo;
        @NotNull private Long pdtSellerNo;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReadList {
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
        private Integer favoriteCount;
        private Boolean favoriteCheck;
        private Integer chatCount;
        private Boolean chatCheck;
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
        private Boolean favoriteCheck;
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
        private String pdtCate;
        private MemDto.Member member;
        private List<PdtDto.ReadList> sellerList;
        private List<PdtDto.ReadList> cateList;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ListData {
        private Long pdtNo;
        @NotEmpty private String addressSi;
        @NotEmpty private String addressGu;
        @NotEmpty private String addressDong;
        @NotNull private Integer start;
        @NotNull private Integer end;
        private String keyword;
        private Long pdtCateNo;
        private String pdtCate;
        private Long pdtSellerNo;
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
