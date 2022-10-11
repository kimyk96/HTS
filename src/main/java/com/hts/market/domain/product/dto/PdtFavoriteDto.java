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
        @NotNull
        private Long pdtNo;
        @NotNull
        private Long memNo;
        public Create toDto(){
            return Create.builder().pdtNo(pdtNo).memNo(memNo).build();
        }
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
