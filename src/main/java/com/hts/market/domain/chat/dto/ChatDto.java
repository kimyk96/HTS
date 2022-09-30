package com.hts.market.domain.chat.dto;

import com.hts.market.domain.chat.entity.ChatEntity;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.security.Timestamp;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ChatDto {
    @Data @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create {
        private Long chatNo;
        private Long memNo;
        @NotEmpty(message = "메세지를 입력해주세요")
        private String chatContent;
        private Long chatListNo;

        public ChatEntity toEntity() {
            return ChatEntity.builder().memNo(memNo).chatContent(chatContent).chatNo(chatNo).build();
        }
    }

    @Data @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Read {
        private Long chatNo;
        private Long memNo;
        private String chatContent;
        private Long chatListNo;
        private LocalDateTime chatCreateAt;
    }
}
