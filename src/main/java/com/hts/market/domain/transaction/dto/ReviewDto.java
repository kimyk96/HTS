package com.hts.market.domain.transaction.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReviewDto {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Read{
        private Long reviewNo;
        private String review;
    }
}
