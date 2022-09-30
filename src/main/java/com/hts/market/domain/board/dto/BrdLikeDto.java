package com.hts.market.domain.board.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BrdLikeDto {
    @Data @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create {
        private Long brdNo;
        private Long brdMemNo;
    }
    @Data @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Delete {
        private Long brdNo;
        private Long brdMemNo;
    }
}
