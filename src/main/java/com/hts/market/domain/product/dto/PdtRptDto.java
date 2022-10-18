package com.hts.market.domain.product.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PdtRptDto {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create{
        private Long rptNo;
        @NotNull
        private Long rptPdtNo;
        private Long rptMemNo;
        @NotNull
        private Long rptMsgNo;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Read {
        private Long rptNo;
        private Long rptMemNo;
        private Long rptPdtNo;
        private Long rptMsgNo;
        private LocalDateTime rptCreatedAt;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Delete{
        private Long rptNo;
        private Long rptMemNo;
        private Long rptPdtNo;
    }
}
