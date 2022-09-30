package com.hts.market.domain.board.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BrdDto {
    @Data @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create{
        private Long brdNo;
        @NotEmpty
        private Long brdMemNo;
        @NotEmpty(message="제목은 필수입력입니다")
        private String brdTitle;
        @NotEmpty(message="내용은 필수입력입니다")
        private String brdContent;
        @NotNull(message="카테고리 선택은 필수입력입니다")
        private Long brdCate;
    }
    @Data @Builder @AllArgsConstructor @NoArgsConstructor
    public static class Read{
        private String brdTitle;
        private String brdContent;
        private Integer brdViews;
        private LocalDateTime brdCreatedAt;
        private Long brdMemNo;
    }
    @Data @Builder @AllArgsConstructor @NoArgsConstructor
    public static class Update{
        private Long brdNo;
        @NotEmpty(message="제목은 필수입력입니다")
        private String brdTitle;
        @NotEmpty(message="내용은 필수입력입니다")
        private String brdContent;
        @NotEmpty(message="카테고리 선택은 필수입력입니다")
        private Long brdCateNo;
    }
    @Data @Builder @AllArgsConstructor @NoArgsConstructor
    public static class Delete{
        private Long brdMemNo;
        private Long brdNo;
    }
}
