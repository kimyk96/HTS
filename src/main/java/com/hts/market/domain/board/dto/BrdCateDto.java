package com.hts.market.domain.board.dto;


import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BrdCateDto {
    @Data @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Read {
        private String brdCateName;
    }
}
