package com.hts.market.domain.product.repo;

import com.hts.market.domain.product.dto.PdtImgDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PdtImgRepo {
    // 이미지 저장
    public Integer save(PdtImgDto.Create dto);
    // 이미지 수정
    public Integer update(PdtImgDto.Update dto);
    // 이미지 개별삭제
    public Integer deleteByImgNo(PdtImgDto.Delete dto);
    // 이미지 전체삭제
    public Integer deleteAll(PdtImgDto.Delete dto);

}
