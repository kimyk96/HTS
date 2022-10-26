package com.hts.market.global.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {
    private Long chatPdtNo;
    private Long chatMemNo;
    private String target;
    private String msg;
    private LocalDateTime now;
}
