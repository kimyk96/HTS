package com.hts.market.domain.product.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PdtCateDto {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Read {
        private Long pdtCateNo;
        private String pdtCate;
    }
}
