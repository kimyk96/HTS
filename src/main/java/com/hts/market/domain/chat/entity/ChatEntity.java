package com.hts.market.domain.chat.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class ChatEntity {
    public Long chatPdtNo;
    public Long chatMemNo;
    public Long chatMsgNo;
    public String chatContent;
    public Boolean chatCheck;
    public LocalDateTime chatCreatedAt;
}




