package com.hts.market.domain.chat.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Builder
@ToString
public class ChatList {
    public Long chatNo;
    public Long pdtNo;
    public Long username;
    public Timestamp createdAt;
}
