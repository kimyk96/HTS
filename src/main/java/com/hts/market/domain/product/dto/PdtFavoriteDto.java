package com.hts.market.domain.product.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PdtFavoriteDto {
    @Data
    public static class Create {
        private long pdtNo;
        private long memNo;
    }

    @Data
    public static class Read {
        private long pdtNo;
        private long memNo;
    }
}
