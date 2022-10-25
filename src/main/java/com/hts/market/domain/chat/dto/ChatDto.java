package com.hts.market.domain.chat.dto;

import com.hts.market.domain.member.dto.MemDto;
import com.hts.market.domain.product.dto.PdtDto;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ChatDto {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create {
        private Long chatMsgNo;
        @NotNull(message = "하잇~") private Long chatMemNo;
        @NotNull private Long chatPdtNo;
        private String chatContent;
        private Integer chatIsSeller;
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
        private Boolean chatIsSeller;
        private LocalDateTime chatCreatedAt;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Pk {
        private Long chatPdtNo;
        private Long chatMemNo;
        private Boolean chatChecked;
        private String chatContent;
        private LocalDateTime chatCreatedAt;
        private MemDto.Member member;
        private String pdtImg;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ListStartEnd {
        private Integer start;
        private Integer end;
        private Long chatPdtNo;
        private Long chatMemNo;
        private Boolean chatChecked;
        private Boolean chatIsSeller;
        private Long chatMsgNo;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ChatMemInfo {
        private Integer chatMemBrix;
        private String chatNickname;
        private String chatMemImg;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ChatUserInfo {
        private MemDto.Member member;
        private PdtDto.Detail product;
        private List<ChatDto.Read> chat;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ChatLike {
        private Long chatMemNo;
        private Long chatPdtNo;
    }
}