package com.hts.market.domain.member.repo;

import com.hts.market.domain.member.dto.MemRptDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemRptRepo {
    // 회원 신고
    Integer save(MemRptDto.Create dto);

    // 신고 누적 확인
    List<Long> findByCount();
    
    // 오래된 신고 제거
    Integer sortTable();
}
