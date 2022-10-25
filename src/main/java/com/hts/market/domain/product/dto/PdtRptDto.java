package com.hts.market.domain.product.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PdtRptDto {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create {
        private Long rptNo;
        @NotNull private Long rptPdtNo;
        private Long rptMemNo;
        @NotNull private Long rptMsgNo;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Search{
        private Long rptMemNo;
        private Long rptPdtNo;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Count{
        private Long rptPdtNo;
        private Integer count;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Delete {
        private Long rptNo;
        private Long rptMemNo;
        private Long rptPdtNo;
    }
}
