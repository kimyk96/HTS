package com.hts.market.domain.board.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CmtDto {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create {
        @NotEmpty(message = "내용은 필수입력입니다") private String cmtContent;
        private Long cmtNo;
        private Long cmtWriterNo;
        @NotNull private Long cmtBrdNo;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Read {
        private String cmtContent;
        private Long cmtWriterNo;
        private Long cmtNo;
        private Long cmtBrdNo;
        private String memNickname;
        private String imgPath;
        private String addressSi;
        private String addressGu;
        private String addressDong;
        private Boolean isWriter;
        private Boolean isBrdWriter;
        private LocalDateTime cmtCreatedAt;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Update {
        @NotEmpty(message = "제목은 필수입력입니다") private String cmtContent;
        @NotNull private Long cmtWriterNo;
        @NotNull private Long cmtNo;
        @NotNull private Long cmtBrdNo;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Delete {
        @NotNull private Long cmtNo;
        @NotNull private Long cmtBrdNo;
        private Long memNo;
    }
}

