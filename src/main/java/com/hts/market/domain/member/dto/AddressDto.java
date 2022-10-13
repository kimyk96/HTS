package com.hts.market.domain.member.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AddressDto {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create {
        private Long addressNo;
        private Long memNo;
        private String addressSi;
        private String addressGu;
        private String addressDong;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Read {
        private Long addressNo;
        private Long memNo;
        private String addressSi;
        private String addressGu;
        private String addressDong;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Delete {
        private Long addressNo;
        private Long memNo;
        private String addressSi;
        private String addressGu;
        private String addressDong;
    }

}
