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
    public Long chatNo;
    public Long memNo;
    public String chatContent;
    public Long chatListNo;
    public LocalDateTime chatCreatedAt;
}




