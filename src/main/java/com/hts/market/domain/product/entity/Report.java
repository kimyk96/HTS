package com.hts.market.domain.product.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Builder
@Getter
public class Report {
    private long rptNo;
    private long rptMemNo;
    private long rptPdtNo;
    private long rptMagNo;
    private LocalDateTime rptCreatedAt;
}
