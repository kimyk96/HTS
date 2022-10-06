package com.hts.market.domain.transaction.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class TxReviewEntity {
    private Long txReviewNo;
    private String txReviewType;
    private Long reviewNo;
}
