package com.hts.market.domain.board.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Builder
public class BrdRptEntity {
    private Long rptNo;
    private Long rptMemNo;
    private Long rptBrdNo;
    private Long rptMsgNo;

}
