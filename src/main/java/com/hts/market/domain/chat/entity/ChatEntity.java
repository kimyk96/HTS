package com.hts.market.domain.chat.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class ChatEntity {
    private Long chatPdtNo;
    private Long chatMemNo;
    private Long chatMsgNo;
    private String chatContent;
    private Boolean chatChecked;
    private LocalDateTime chatCreatedAt;
    private String username;
    private boolean isSeller;
}



