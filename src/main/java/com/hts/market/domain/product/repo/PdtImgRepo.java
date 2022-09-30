package com.hts.market.domain.product.repo;

import com.hts.market.domain.product.dto.PdtImgDto;
import org.apache.ibatis.annotations.Mapper;

import java.awt.*;

@Mapper
public interface PdtImgRepo {
    // 이미지 저장
    public Image save(PdtImgDto.Create dto);
    // 이미지 수정
    public Integer update(PdtImgDto.Update dto);
    // 이미지 보기
    public Integer findByImgNo(PdtImgDto.Read dto);
    // 이미지 삭제
    public Integer delete(PdtImgDto.Delete dto);
}
