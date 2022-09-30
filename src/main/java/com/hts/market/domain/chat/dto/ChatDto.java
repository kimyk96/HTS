package com.hts.market.domain.chat.dto;

import com.hts.market.domain.chat.entity.ChatEntity;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.security.Timestamp;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ChatDto {
    @Data @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create {
        private Long chatMsgNo;
        @NotNull(message = "하잇~")
        private Long chatMemNo;
        private Long chatPdtNo;
        @NotEmpty(message = "메세지를 입력해주세요")
        private String chatContent;

    }

    @Data @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Read {
        private Long chatMsgNo;
        private Long chatMemNo;
        private Long chatPdtNo;
        private String chatContent;
        private Boolean chatChecked;
    }
}
