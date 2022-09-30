package com.hts.market.domain.member.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class MemRptDto {
    @Data
    @Builder @AllArgsConstructor
    @NoArgsConstructor
    public static class Create{
        private Long rptNo;
        private Long rptMemNo;
        private Long rptTargetNo;
        private Long rptMsgNo;
        private LocalDateTime rptCreatedAt;
    }
    @Data
    @Builder @AllArgsConstructor
    @NoArgsConstructor
    public static class Read{
        private Long rptNo;
        private Long rptMemNo;
        private Long rptTargetNo;
        private Long rptMsgNo;
        private LocalDateTime rptCreatedAt;
    }
    @Data
    @Builder @AllArgsConstructor
    @NoArgsConstructor
    public static class Update{
        private Long rptNo;
        private Long rptMemNo;
        private Long rptTargetNo;
        private Long rptMsgNo;
        private LocalDateTime rptCreatedAt;
    }
    @Data
    @Builder @AllArgsConstructor
    @NoArgsConstructor
    public static class Delete{
        private Long rptNo;
        private Long rptMemNo;
        private Long rptTargetNo;
        private Long rptMsgNo;
        private LocalDateTime rptCreatedAt;
    }
}
