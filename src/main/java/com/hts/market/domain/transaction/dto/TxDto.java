package com.hts.market.domain.transaction.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TxDto {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create{
        private Long txNo;
        @NotNull
        private Long pdtNo;
        @NotNull
        private Long buyerNo;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Read{
        private Long txNo;
        private Long pdtNo;
        private Long buyerNo;
    }

}
