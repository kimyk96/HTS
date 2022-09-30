package com.hts.market.domain.board.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@NoArgsConstructor
public class BrdLike {
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
