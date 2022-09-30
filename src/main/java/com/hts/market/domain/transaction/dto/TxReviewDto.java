package com.hts.market.domain.transaction.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TxReviewDto {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create{
        private Long txNo;
        @NotNull
        private Long reviewNo;
    }
}
