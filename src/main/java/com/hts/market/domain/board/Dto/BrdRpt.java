package com.hts.market.domain.board.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
public class BrdRpt {
    @Data

    public static class Create {
        private Integer brdNo;
        private String brdWriter;
        @NotEmpty(message="신고 메시지는 필수입력입니다")
        private String RptMsg;
    }
}
