package com.hts.market.domain.product.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PdtRtpDto {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create{
        private Long rptNo;
        private Long rptMemNo;
        private Long rptPdtNo;
        private Long rptMsgNo;
        private LocalDateTime rptCreatedAt;
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
    public static class Delete{
        private Long rptNo;
        private Long rptMemNo;
        private Long rptPdtNo;
        private Long rptMsgNo;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Page{
        private Long rptNo;
        private Long rptMemNo;
        private Long rptPdtNo;
        private Long rptMsgNo;
        private LocalDateTime rptCreatedAt;
    }
}
