package com.hts.market.domain.member.repo;

import com.hts.market.domain.member.dto.MemRoleDto;
import com.hts.market.domain.member.dto.RoleDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleRepo {
    // 권한 그룹 추가
    public Integer save(RoleDto.Create dto);
    // 권한명 조회
    public RoleDto.Read findById(Long roleNo);
    // 권한 번호 조회
    public RoleDto.Read findByRoleName(String roleName);
}
