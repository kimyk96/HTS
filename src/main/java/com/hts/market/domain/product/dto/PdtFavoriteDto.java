package com.hts.market.domain.product.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Collection;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PdtFavoriteDto {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create {
        @NotNull
        private Long pdtNo;
        @NotNull
        private Long memNo;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Page {
        private Long pageNo;
        private Long totalNo;
        private Collection<ReadList> boardList;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReadList{
        private Long pdtNo;
        private Long memNo;
        private String imgPath;
        private String pdtName;
        private String addressSi;
        private String addressGu;
        private String addressDong;
        private Integer price;
    }
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Delete{
        @NotNull
        private Long pdtNo;
        @NotNull
        private Long memNo;
    }
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CountFavorite{
        private Long pdtNo;
        private Long memNo;
    }
}
