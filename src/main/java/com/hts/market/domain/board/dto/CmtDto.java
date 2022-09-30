package com.hts.market.domain.board.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;
import java.time.LocalDateTime;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CmtDto {

    @Data @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create {
    @NotEmpty(message = "내용은 필수입력입니다")
    private String cmtContent;
    private Long brdNo;
    private Long brdMemNo;
    }

    @Data @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Read {
    private String cmtContent;
    private Long cmtMemNo;
    private LocalDateTime cmtCreateAt;
    }

    @Data @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Update{
        @NotEmpty(message="제목은 필수입력입니다")
        private String cmtContent;
        private Long cmtMemNo;
        private Long brdNo;
    }
    @Data @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Delete{
        private Long cmtMemNo;
    }

 }

