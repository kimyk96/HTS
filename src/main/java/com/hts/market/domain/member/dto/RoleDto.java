package com.hts.market.domain.member.dto;

import lombok.*;

@Getter
@Builder
@ToString
public class RoleDto {
    @Data @Builder @AllArgsConstructor @NoArgsConstructor
    public static class Read{
        private Long roleNo;
        private String roleName;
    }
}
