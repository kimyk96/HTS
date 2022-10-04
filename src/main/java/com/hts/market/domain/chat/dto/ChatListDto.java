package com.hts.market.domain.chat.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ChatListDto {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ListDto{
        public Long chatPdtNo;
        public Long chatMemNo;
        public String chatContent;
    }
}
