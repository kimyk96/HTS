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
    // 이미지 개별삭제
    public Integer deleteByImgNo(PdtImgDto.Delete dto);
    // 이미지 전체삭제
    public Integer deleteAll(Long pdtNo);
    // 상품 이미지 조회
    public List<PdtImgDto.Read> searchOfPdtNo(Long pdtNo);
    // 메인 이미지 조회
    public String findMainImg(Long pdtNo);
}
