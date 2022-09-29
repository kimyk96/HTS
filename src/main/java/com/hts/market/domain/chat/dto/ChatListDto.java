package com.hts.market.domain.chat.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ChatListDto {
    @Data
    public static class ListDto{
        private Long chatNo;
        private String username;
        private String message;
        private String nickname;
    }
}
