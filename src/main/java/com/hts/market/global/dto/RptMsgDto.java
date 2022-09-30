package com.hts.market.global.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RptMsgDto {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create {
        private Long rptMsgNo;
        private String rptMsg;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Read {
        private Long rptMsgNo;
        private String rptMsg;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Update {
        private Long rptMsgNo;
        private String rptMsg;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Delete {
        private Long rptMsgNo;
        private String rptMsg;
    }

}
