package com.hts.market.domain.board.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BrdImgDto {

    @Data @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create {
        private Long brdImgNo;
    }
    @Data @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Update{
        private Long brdImgNo;
        private Long brdNo;
        private Long brdWriter;
    }
    @Data @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Delete{
        private Long brdImgNo;
        private Long brdNo;
        private Long brdWriter;//작성자가 아니면 삭제할수,,,,,,,,,
    }

}
