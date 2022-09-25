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
    private String from;			// 보내는 메일
    private String to;				// 받는 메일
    private String subject;			// 제목
    private String text;			// 내용
}
