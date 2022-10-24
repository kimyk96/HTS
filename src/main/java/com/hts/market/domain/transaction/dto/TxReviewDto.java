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
    public static class SaveReview{
        private Long txNo;
        private Long txPdtNo;
        private Long memNo;
        private String txReviewType;
        private List<Long> checked;
    }
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create{
        private Long txNo;
        private Long reviewNo;
        private String txReviewType;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Read{
        private Long txNo;
        private Long txPdtNo;
        private Boolean isSeller;
        private String txReviewType;
    }
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReadList{
        private Long txNo;
        private String memNickname;
        private String pdtName;
        private List<String> reviews;
    }
}
