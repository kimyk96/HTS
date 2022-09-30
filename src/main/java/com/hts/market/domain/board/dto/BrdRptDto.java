package com.hts.market.domain.board.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BrdRptDto {
    @Data @Builder
    @AllArgsConstructor
    @NoArgsConstructor

    public static class Create {
        private Long brdNo;
        private Long brdMemNo;
        @NotEmpty(message="신고 메시지는 필수입력입니다")
        private String RptMsg;
    }
}
