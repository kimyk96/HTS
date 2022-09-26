package com.hts.market.domain.member.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class MemImgEntity {
    private Long memNo;
    private Long imgNo;
    private String imgPath;
}
