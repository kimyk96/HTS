package com.hts.market.domain.board.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BrdDto {
    @Data @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create{
        @NotNull
        private Long brdNo;
        @NotNull
        private Long brdWriterNo;
        @NotEmpty(message="제목은 필수입력입니다")
        private String brdTitle;
        @NotEmpty(message="내용은 필수입력입니다")
        private String brdContent;
        @NotNull(message="카테고리 선택은 필수입력입니다")
        private Long brdCateNo;
    }
    @Data @Builder @AllArgsConstructor @NoArgsConstructor
    public static class Read{
        private Long brdNo;
        private String brdTitle;
        private String brdContent;
        private Integer brdViews;
        private LocalDateTime brdCreatedAt;
        private Long brdWriterNo;
        private String brdCate;
        private String imgPath;
        private Long brdCmt;
        private String cmtWriter;
        private String cmtContent;
        private LocalDateTime cmtCreatedAt;
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
        private Long brdWriterNo;
        private Long brdNo;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Page{
        private Long pageNo;
        private Integer pageSize;
        private Long totalNo;
        private Collection<BrdDto.Read> brdList;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ViewCount {
        private Long brdNo;
        private Long brdWriterNo;
    }
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SearchData{
        private Integer start;
        private Integer end;
        private String brdTitle;
        private String brdContent;
        private Long brdCateNo;
        private String brdCate;
        private Long brdWriter;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Detail {
        private BrdDto.Read board;
        private List<BrdImgDto.Read> images;
        // board_category 에서 가져온 값
        private String brdCate;
    }




}
