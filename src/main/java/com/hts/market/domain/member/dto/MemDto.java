package com.hts.market.domain.member.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemDto {
    @Data @Builder @AllArgsConstructor @NoArgsConstructor
    public static class Create{
        private Long memNo;
        private String memUsername;
        private String memPassword;
        private String memEmail;
        private String memNickname;
        private Integer memIsEnabled;
    }
    @Data @Builder @AllArgsConstructor @NoArgsConstructor
    public static class Read{
        private Long memNo;
        private String memUsername;
        private String memPassword;
        private String memNickname;
        private String memEmail;
        private Integer memBrix;
        private LocalDateTime memCreatedAt;
    }
    @Data @Builder @AllArgsConstructor @NoArgsConstructor
    public static class Update{
        private Long memNo;
        private String memUsername;
        private String memPassword;
        private String memNickname;
        private String memEmail;
    }
    @Data @Builder @AllArgsConstructor @NoArgsConstructor
    public static class Member{
        private Long memNo;
        private String memUsername;
        private String memNickname;
        private String memEmail;
        private Integer memBrix;
        private LocalDateTime memCreatedAt;
        private Long imgNo;
        private String imgPath;
        private List<AddressDto.Read> address;
    }
    @Data @Builder @AllArgsConstructor @NoArgsConstructor
    public static class Profile{
        private Long memNo;
        private String memUsername;
        private String memNickname;
        private MultipartFile image;
    }
}
