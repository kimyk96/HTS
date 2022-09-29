package com.hts.market.domain.transection.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class ReviewEntity {
    private long reviewNo;
    private String review;
}
