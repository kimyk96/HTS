package com.hts.market.global.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@Builder
@Accessors(chain=true)
public class MailEntity {
    private String from;			// 보내는이
    private String to;				// 받는이
    private String subject;			// 제목
    private String body;			// 내용
}
