package com.hts.market.domain.member.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import net.bytebuddy.asm.Advice;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class MemRptEntity {
    private Long rptNo;
    private Long rptMemNo;
    private Long rptTargetNo;
    private Long rptMsgNo;
    private LocalDateTime rptCreatedAt;
}