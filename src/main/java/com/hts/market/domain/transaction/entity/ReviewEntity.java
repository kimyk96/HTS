package com.hts.market.domain.transaction.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class ReviewEntity {
    private Long reviewNo;
    private String review;
}
