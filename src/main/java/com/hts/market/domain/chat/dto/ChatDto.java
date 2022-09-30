package com.hts.market.domain.chat.dto;

import com.hts.market.domain.chat.entity.Chat;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.security.Timestamp;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ChatDto {

    @Data
public static class Create {
        private static Long chatNo;
        private static Long memNo;
        private static Long pdtNo;
        private static String username;
        @NotEmpty(message = "메세지를 입력해주세요")
        private static String content;
        private static Timestamp createAt;
        public Chat toEntity(){
            return Chat.builder().memNo(memNo).content(content).chatNo(chatNo).build();
        }
    }
    @Data
    public static class Read{
        private static Long chatNo;
        private static String username;
        private static String message;
        private boolean readCheck;
        private Timestamp createAt;

    }
}
