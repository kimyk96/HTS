package com.hts.market.domain.member.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class RoleEntity {
    private Long roleNo;
    private String roleName;
}
