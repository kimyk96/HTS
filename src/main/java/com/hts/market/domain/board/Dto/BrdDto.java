package com.hts.market.domain.board.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@NoArgsConstructor
public class BrdDto {
    @Data
    public static class Create{
        @NotEmpty(message="제목은 필수입력입니다")
        private String brdTitle;
        @NotEmpty(message="내용은 필수입력입니다")
        private String brdContent;
        @NotEmpty(message="카테고리 선택은 필수입력입니다")
        private String brdCate;
    }
    public static class Read{
        private String brdTitle;
        private String brdContent;
        private Integer brdViews;
        private LocalDateTime brdCreatedAt;
        private String brdWriter;
    }
    public static class Update{
        @NotEmpty(message="제목은 필수입력입니다")
        private String brdTitle;
        @NotEmpty(message="내용은 필수입력입니다")
        private String brdContent;
        @NotEmpty(message="카테고리 선택은 필수입력입니다")
        private String brdCate;
    }
    public static class Delete{
        private String brdWriter;

    }
}
