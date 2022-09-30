package com.hts.market.domain.product.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PdtCateDto {
    @Data
    public static class Read {
        private long pdtCateNo;
        private String pdtCate;
    }
}
