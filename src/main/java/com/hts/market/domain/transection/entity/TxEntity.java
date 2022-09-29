package com.hts.market.domain.transection.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class TxEntity {
    private long txNo;
    private long pdtNo;
    private long buyerNo;
    private LocalDateTime txCreatedAt;

}
