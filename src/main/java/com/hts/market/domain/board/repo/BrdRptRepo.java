package com.hts.market.domain.board.repo;

import com.hts.market.domain.board.dto.BrdRptDto;
import com.hts.market.domain.product.dto.PdtRptDto;
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

    // 신고자번호 조회
    public Integer findIdBySearch(BrdRptDto.Search dto);

    // 신고자 일일 신고횟수 체크
    public  Integer countOfMemNo(Long memNo);
    // 신고전체삭제
    public Integer deleteAll();
    // 신고누적5회인 글번호 조회
    public List<Long> findBrdNoByCount();
}
