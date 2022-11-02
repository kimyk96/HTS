package com.hts.market.global.dto;

import lombok.*;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RptMsgDto {
    private Long rptMsgNo;
    private String rptMsg;
}
