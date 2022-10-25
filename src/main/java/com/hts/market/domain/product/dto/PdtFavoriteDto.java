package com.hts.market.domain.product.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PdtFavoriteDto {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create {
        @NotNull private Long pdtNo;
        private Long memNo;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Delete {
        @NotNull private Long pdtNo;
        private Long memNo;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReadList {
        private Long memNo;
        @NotNull private Integer start;
        @NotNull private Integer end;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CountFavorite {
        private Long pdtNo;
        private Long memNo;
    }
}
