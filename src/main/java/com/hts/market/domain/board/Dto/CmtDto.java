package com.hts.market.domain.board.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@NoArgsConstructor
public class CmtDto {

    @Data
    public static class Create {
    @NotEmpty(message = "내용은 필수입력입니다")
    private String cmtContent;
    private Integer brdNo;
    }

    public static class Read {
    private String cmtContent;
    private String cmtWriter;
    private LocalDateTime cmtCreateAt;
    }

    public static class Update{
        private String cmtContent;
        private String cmtWriter;
    }

    public static class Delete{
        private String cmtWriter;
    }

 }

