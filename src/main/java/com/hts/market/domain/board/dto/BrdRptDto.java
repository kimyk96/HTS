package com.hts.market.domain.board.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BrdRptDto {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Search{
        private Long rptMemNo;
        private Long rptBrdNo;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create {
        private Long rptNo;
        private Long rptBrdNo;
        private Long rptMemNo;
        private Long rptMsgNo;
        private LocalDateTime rptCreatedAt;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Read {
        private Long rptNo;
        private Long rptBrdNo;
        private Long rptMemNo;
        private Long rptMsgNo;
        private LocalDateTime rptCreatedAt;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Delete {
        private Long rptNo;
        private Long rptBrdNo;
        private Long rptMemNo;
    }
}
