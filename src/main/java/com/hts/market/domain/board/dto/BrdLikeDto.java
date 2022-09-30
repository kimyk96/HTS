package com.hts.market.domain.board.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BrdLikeDto {
    @Data
    public static class Create {
        private Long brdNo;
        private Long brdMemNo;
    }

    public static class Delete {
        private Long brdNo;
        private Long brdMemNo;
    }
}
