package com.hts.market.domain.product.repo;

import com.hts.market.domain.product.dto.PdtRptDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PdtRptRepo {
    // 신고등록
    public Integer save(PdtRptDto.Create dto);
    // 신고삭제
    public Integer delete(PdtRptDto.Delete dto);
    // 회원별 삭제
    public Integer deleteByRptMemNo(PdtRptDto.Delete dto);
    // 상품별 삭제
    public Integer deleteByRptPdtNo(PdtRptDto.Delete dto);
    // 신고보기
    public PdtRptDto.Read findByRptNo(PdtRptDto.Read dto);
    // 신고목록
    public List<PdtRptDto.Read> findAll();
}
