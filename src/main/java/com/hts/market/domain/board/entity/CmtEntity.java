package com.hts.market.domain.board.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
@Builder
public class CmtEntity {
    private Long cmtNo;
    private Long brdNo;
    private Long cmtWriterNo;
    private String cmtContent;
    private LocalDateTime cmtCreatedAt;
}
