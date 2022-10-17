package com.hts.market.domain.board.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BrdLikeDto {
    @Data @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create {
        @NotNull
        private Long brdNo;
        @NotNull
        private Long memNo;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Page {
        private Long brdNo;
        private Long memNo;
    }
    @Data @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Delete {
        @NotNull
        private Long brdNo;
        @NotNull
        private Long memNo;
    }
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CountLikes{
        private Long brdNo;
        private Long memNo;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReadList{
        private Long brdNo;
        private Long memNo;
        private String imgPath;
        private String brdTitle;
    }

}
