package com.hts.market.domain.chat.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Builder
@ToString
public class Chats {
    public long ChatNo;
    public long memberNo;
    public long chatListNo;
    public String chatStatus;
    public String content;
    public Timestamp createdAt;
}




