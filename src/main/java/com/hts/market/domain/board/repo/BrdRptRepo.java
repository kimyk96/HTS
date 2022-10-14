package com.hts.market.domain.board.repo;

import com.hts.market.domain.board.dto.BrdRptDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface BrdRptRepo {
    public Integer save(BrdRptDto.Create dto);

//    신고삭제
    public Integer delete(BrdRptDto.Delete dto);

//    신고보기

    public BrdRptDto.Read findByRptNo(BrdRptDto.Read dto);

//    신고목록
    public List<BrdRptDto.Read> findAll(BrdRptDto.Read dto);
}
