package com.hts.market.domain.transection.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class TxReviewEntity {
    private long txNo;
    private String txReviewType;
    private long reviewNo;
}
