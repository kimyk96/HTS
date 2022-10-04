package com.hts.market.domain.product.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Builder
@Getter
public class PdtRptEntity {
    private Long rptNo;
    private Long rptMagNo;
    private Long rptMemNo;
    private Long rptPdtNo;
    private LocalDateTime rptCreatedAt;
}
