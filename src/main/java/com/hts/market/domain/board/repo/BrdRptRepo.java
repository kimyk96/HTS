package com.hts.market.domain.board.repo;

import com.hts.market.domain.board.dto.BrdRptDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BrdRptRepo {
    // 신고 저장
    public Integer save(BrdRptDto.Create dto);

    // 신고 삭제
    public Integer delete(BrdRptDto.Delete dto);

    // 신고 조회
    public BrdRptDto.Read findByRptNo(BrdRptDto.Read dto);

    // 신고 목록
    public List<BrdRptDto.Read> findAll(BrdRptDto.Read dto);
}
