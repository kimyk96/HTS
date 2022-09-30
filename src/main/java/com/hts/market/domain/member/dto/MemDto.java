package com.hts.market.domain.member.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemDto {
    @Data @Builder @AllArgsConstructor @NoArgsConstructor
    public static class CreateTemp{
        private Long memNo;
    }

    @Data @Builder @AllArgsConstructor @NoArgsConstructor
    public static class Create{
        private Long memNo;
        private String memUsername;
        private String memPassword;
        private String memName;
        private String memNickname;
        private String memEmail;
        private Integer memPhone;
////        private Integer memBrix;
////        private LocalDateTime memCreatedAt;
        private String memAccessToken;
        private String memRefreshToken;
        private String memSignupType;
    }
    @Data @Builder @AllArgsConstructor @NoArgsConstructor
    public static class Read{
        private Long memNo;
        private String memUsername;
        private String memPassword;
        private String memName;
        private String memNickname;
        private String memEmail;
        private Integer memPhone;
        private Integer memBrix;
        private LocalDateTime memCreatedAt;
    }
    @Data @Builder @AllArgsConstructor @NoArgsConstructor
    public static class Update{
        private Long memNo;
//        private String memUsername;
//        private String memPassword;
//        private String memName;
        private String memNickname;
        private String memEmail;
//        private Integer memPhone;
//        private Integer memBrix;
//        private LocalDateTime memCreatedAt;
    }
    @Data @Builder @AllArgsConstructor @NoArgsConstructor
    public static class UpdatePhone{
        private Long memNo;
        private Integer memPhone;
    }
}
