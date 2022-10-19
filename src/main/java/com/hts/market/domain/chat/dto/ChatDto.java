package com.hts.market.domain.chat.dto;

import com.hts.market.domain.member.dto.MemDto;
import com.hts.market.domain.product.dto.PdtDto;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
        @NotNull
        private Long chatPdtNo;
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
//{
//    member: {
//        mem_nickname: "한라봉 소년단",
//        mem_brix: 10,
//        mem_username: 01027249409,
//        mem_profile_img: "https://localhostsdjgbasfgo.comasdf/dsff.png"
//    },
//    product: {
//        pdt_img : "dsgoahsjlfgnalksf",
//        pdt_name : "삼성 오딧세이 노트북",
//        pdt_price : 680000
//    },
//        chat: [{ pdt_no : 1,
//        msg_no: 1,
//        msg_content : "안녕하세욤ㅇ루민ㅇ",
//        checked: 1,
//        msg_created_at : 시간,
//        is_seller : 1 },{ pdt_no : 1,
//        msg_no: 1,
//        msg_content : "안녕하세욤ㅇ루민ㅇ",
//        checked: 1,
//        msg_created_at : 시간,
//        is_seller : 1 },{ pdt_no : 1,
//        msg_no: 1,
//        msg_content : "안녕하세욤ㅇ루민ㅇ",
//        checked: 1,
//        msg_created_at : 시간,
//        is_seller : 1 }]
//}

