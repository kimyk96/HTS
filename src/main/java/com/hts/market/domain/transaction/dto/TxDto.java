package com.hts.market.domain.transaction.dto;

import com.hts.market.domain.member.dto.AddressDto;
import com.hts.market.domain.product.dto.PdtDto;
import lombok.*;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TxDto {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create {
        private Long txNo;
        private Long txPdtNo;
        private Long txBuyerNo;
        private Integer pdtStatus;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Read {
        private Long txNo;
        private Long txPdtNo;
        private Long txBuyerNo;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class GetList {
        private Long memNo;
        private Integer start;
        private Integer end;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReadList {
        private TxDto.Read transaction;
        private PdtDto.Read product;
        private AddressDto.Read address;
        private String pdtImg;
        private Integer chatCount;
        private Boolean chatCheck;
        private Boolean receivedReviewCheck;
        private Boolean sentReviewCheck;
    }
}
