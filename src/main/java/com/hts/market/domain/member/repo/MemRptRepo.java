package com.hts.market.domain.member.repo;

import com.hts.market.domain.member.dto.MemRptDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemRptRepo {
    // 회원 신고
    Integer save(MemRptDto.Create dto);
}
