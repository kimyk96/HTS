package com.hts.market.domain.chat.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Builder
@ToString
public class Chat {
    public long chatNo;
    public String username;
    public long chatListNo;
    public String chatStatus;
    public String content;
    public Timestamp createdAt;
    public Long memNo;
}




