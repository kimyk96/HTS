package com.hts.market.domain.member.repo;

import com.hts.market.domain.member.dto.MemRoleDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemRoleRepo {
    public List<MemRoleDto.Read> findAllByMemNo(Long memNo);
}
