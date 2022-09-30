package com.hts.market.domain.product.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PdtFavoriteDto {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create {
        private Long pdtNo;
        private Long memNo;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Page {
        private Long pdtNo;
        private Long memNo;
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
    public static class CountFavorite{
        private Long pdtFavoriteNo;
        private Long pdtNo;
        private Long memNo;
    }
}
