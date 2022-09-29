package com.hts.market.domain.transection.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TxReviewDto {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create{
        private long txNo;
        private long review;
    }
}
