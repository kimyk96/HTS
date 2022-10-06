package com.hts.market.domain.product.repo;

import com.hts.market.domain.product.dto.PdtImgDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PdtImgRepo {
    // 이미지 저장
    public Integer save(PdtImgDto.Create dto);
    // 이미지 수정
    public Integer update(PdtImgDto.Update dto);
    // 대표이미지 보기
    public String findMainImg(Long pdtNo);
    // 이미지 모두보기
    public List<PdtImgDto.Read> findAllByPdtNo(Long pdtNo);
    // 이미지 삭제
    public Integer delete(PdtImgDto.Delete dto);
}
