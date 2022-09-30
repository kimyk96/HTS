package com.hts.market.domain.product.repo;

import com.hts.market.domain.product.dto.PdtRtpDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PdtRptRepo {
    // 신고등록
    public Integer save(PdtRtpDto.Create dto);
    // 신고삭제
    public Integer delete(PdtRtpDto.Delete dto);
    // 신고목록
    public Integer findByRptNo(PdtRtpDto.Read dto);
    // 신고보기
    public  Integer findAll(PdtRtpDto.Page dto);
}
