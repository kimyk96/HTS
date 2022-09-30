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
        private Long chatMsgNo;
        private Long chatMemNo;
        private Long chatPdtNo;
        @NotEmpty(message = "메세지를 입력해주세요")
        private String chatContent;
        private LocalDateTime chatCreatedAt;

        public ChatEntity toEntity() {
            return ChatEntity.builder().chatContent(chatContent).build();
        }
    }

    @Data @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Read {
        private Long chatMsgNo;
        private Long memNo;
        private Long chatPdtNo;
        private String chatContent;
        private Boolean chatChecked;
        private LocalDateTime chatCreateAt;


    }
}
