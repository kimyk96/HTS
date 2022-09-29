package com.hts.market.domain.transection.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReviewDto {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Read{
        private long reviewNo;
        private String review;
    }
}
