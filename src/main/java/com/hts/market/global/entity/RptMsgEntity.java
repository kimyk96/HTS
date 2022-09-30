package com.hts.market.global.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class RptMsgEntity {
    private Long rptMsgNo;
    private String rptMsg;
}
