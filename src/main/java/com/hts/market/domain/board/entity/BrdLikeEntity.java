package com.hts.market.domain.board.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BrdLikeEntity {
    private Long brdNo;
    private Long memNo;
}
