package com.hts.market.domain.board.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BrdImgDto {

    @Data @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create {
        private Long imgNo;
        private Long brdNo;
        private String imgPath;

    }
    @Data @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Update{
        private Long imgNo;
        private Long brdNo;
        private String imgPath;
    }

    @Data @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Read{
        private Long imgNo;
        private Long brdNo;
        private String imgPath;
    }
    @Data @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Delete{
        private Long imgNo;
        private Long brdNo;
    }

}
