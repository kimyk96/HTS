package com.hts.market.domain.member.dto;

import lombok.*;

@Getter
@Builder
@ToString
public class MemImgDto {
    @Data
    @Builder @AllArgsConstructor
    @NoArgsConstructor
    public static class Create{
        private Long memNo;
        private Long imgNo;
        private String imgPath;
    }
    @Data
    @Builder @AllArgsConstructor
    @NoArgsConstructor
    public static class Read{
        private Long memNo;
        private Long imgNo;
        private String imgPath;
    }
    @Data
    @Builder @AllArgsConstructor
    @NoArgsConstructor
    public static class Update{
        private Long memNo;
        private Long imgNo;
        private String imgPath;
    }
    @Data
    @Builder @AllArgsConstructor
    @NoArgsConstructor
    public static class Delete{
        private Long memNo;
        private Long imgNo;
        private String imgPath;
    }
}
