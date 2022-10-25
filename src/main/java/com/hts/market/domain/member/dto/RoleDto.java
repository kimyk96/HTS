package com.hts.market.domain.member.dto;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RoleDto {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create {
        private Long roleNo;
        private String roleName;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Read {
        private Long roleNo;
        private String roleName;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Update {
        private Long roleNo;
        private String roleName;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Delete {
        private Long roleNo;
        private String roleName;
    }
}
