package com.hts.market.domain.chat.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ChatDto {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create {
        private Long chatMsgNo;
        @NotNull(message = "하잇~")
        private Long chatMemNo;
        private Long chatPdtNo;
        @NotEmpty(message = "메세지를 입력해주세요")
        private String chatContent;
        private Boolean isSellerNo;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Read {
        private Long chatMsgNo;
        private Long chatMemNo;
        private Long chatPdtNo;
        private String chatContent;
        private Boolean chatChecked;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PK {
        public Long chatPdtNo;
        public Long chatMemNo;
        public Long chatMsgNo;

    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class scroll {
        public Integer start;
        public Integer end;
        public Long chatPdtNo;
        public Long chatMemNo;

    }

}
