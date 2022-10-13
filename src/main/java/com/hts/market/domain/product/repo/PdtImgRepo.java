package com.hts.market.domain.product.repo;

import com.hts.market.domain.product.dto.PdtImgDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PdtImgRepo {
    // 이미지 저장
    public Integer save(PdtImgDto.Create dto);
    // 이미지 수정
    public Integer update(PdtImgDto.Update dto);
    // 이미지 삭제
    public Integer delete(PdtImgDto.Delete dto);
//    // 대표이미지 보기
//    public String findMainImg(PdtImgDto.Read dto);
//    // 이미지 모두보기
//    public List<PdtImgDto.Read> findAllByPdtNo(Long pdtNo);
}
