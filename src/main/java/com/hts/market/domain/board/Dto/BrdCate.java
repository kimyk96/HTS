package com.hts.market.domain.board.Dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BrdCate {
    @Data
    public static class Read {
        private String brdCateName;
    }
}
