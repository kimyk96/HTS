package com.hts.market.domain.product.repo;

import com.hts.market.domain.product.dto.PdtRptDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PdtRptRepo {
    // 신고등록
    public Integer save(PdtRptDto.Create dto);
    // 신고목록
    public List<PdtRptDto.Read> findAllByDto(PdtRptDto.Read dto);
    // 신고삭제
    public Integer deleteByRptNo(PdtRptDto.Delete dto);
    // 회원별 삭제
    public Integer deleteByRptMemNo(PdtRptDto.Delete dto);
    // 상품별 삭제
    public Integer deleteByRptPdtNo(Long pdtNo);
    // 신고자번호 조회
    public PdtRptDto.Read findIdByReadDto(PdtRptDto.Read dto);



}
