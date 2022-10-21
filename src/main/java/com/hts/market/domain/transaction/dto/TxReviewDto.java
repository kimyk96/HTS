package com.hts.market.domain.transaction.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TxReviewDto {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create{
        @NotNull
        private Long txReviewNo;
        @NotEmpty
        private String txReviewType;
        @NotNull
        private Long reviewNo;


    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Read{
        @NotNull
        private Long txReviewNo;
        @NotEmpty
        private String txReviewType;
        @NotNull
        private Long reviewNo;



    }
}
