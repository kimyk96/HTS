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
    private Long rptPdtNo;
    private Long rptMemNo;
    private Long rptMsgNo;
    private LocalDateTime rptCreatedAt;
}
