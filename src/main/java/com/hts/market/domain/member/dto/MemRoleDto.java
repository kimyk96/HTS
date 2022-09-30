package com.hts.market.domain.member.dto;

import lombok.*;

@Getter
@Builder
@ToString
public class MemRoleDto {
    @Data @Builder @AllArgsConstructor @NoArgsConstructor
    public static class Create{
        private Long memNo;
        private Long roleNo;
    }
    @Data @Builder @AllArgsConstructor @NoArgsConstructor
    public static class Read{
        private Long memNo;
        private Long roleNo;
    }
}
