package com.hts.market.domain.member.repo;

import com.hts.market.domain.member.dto.RoleDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleRepo {
    public RoleDto.Read findById(Long roleNo);
    public RoleDto.Read findByRoleName(String roleName);
}
