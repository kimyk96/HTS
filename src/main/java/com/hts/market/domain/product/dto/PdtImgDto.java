package com.hts.market.domain.product.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PdtImgDto {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create {
        private Long pdtNo;
        private Long imgNo;
        @NotEmpty
        private String imgPath;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Update {
        private Long pdtNo;
        private Long imgNo;
        @NotEmpty
        private String imgPath;
    }
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Read{
        private Long memNo;
        private Long pdtNo;
        private Long imgNo;
        private String imgPath;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Delete {
        private Long pdtNo;
        private Long ImgNo;
        private Long memNo;
    }
}
