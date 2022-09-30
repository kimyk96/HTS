package com.hts.market.domain.board.entity;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
@Builder
public class BrdEntity {
    private Long brdNo;
    private String brdTitle;
    private String brdContent;
    private Integer brdViews;
    private Long brdMemNo;
    private LocalDateTime brdCreatedAt;
    private Long brdCateNo;
}
