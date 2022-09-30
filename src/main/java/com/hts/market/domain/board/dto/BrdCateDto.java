package com.hts.market.domain.board.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BrdCateDto {
    @Data
    public static class Read {
        private String brdCateName;
    }
}
