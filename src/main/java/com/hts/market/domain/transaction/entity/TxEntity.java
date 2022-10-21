package com.hts.market.domain.transaction.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Builder
@Getter
public class TxEntity {
    private Long txNo;
    private Long txPdtNo;
    private Long txBuyerNo;
    private LocalDateTime txCreatedAt;
}
