package com.hts.market.domain.board.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BrdImgEntity {
    private Long brdNo;
    private Long imgNo;
    private String imgPath;

}
