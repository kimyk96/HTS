package com.hts.market.domain.transection.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TxDto {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create{
        private long txNo;
        private long pdtNo;
        private long buyerNo;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Read{
        private long txNo;
        private long pdtNo;
        private long buyerNo;
    }

}
