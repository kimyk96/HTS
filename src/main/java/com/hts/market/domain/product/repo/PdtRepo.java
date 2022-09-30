package com.hts.market.domain.product.repo;


import com.hts.market.domain.product.dto.PdtDto;
import com.hts.market.domain.product.entity.PdtEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PdtRepo {
    // 판매글 작성
    public PdtEntity save(PdtDto.Create dto);
    // 판매글 수정
    public Integer update(PdtDto.Update dto);
    // 판매글 조회수 증가
    public Integer countByPdtNo(Integer views, String username);
    // 판매글 삭제
    public Integer delete(PdtDto.Delete dto);
    // 키워드 검색
    public PdtDto.KeywordSearch findByPdtKeywordLike(PdtDto.KeywordSearch dto);
    // 판매자명 검색
    public Integer findByPdtSellerLike(Long pdtSellerNo);
    // 판매자별 글목록
    public PdtDto.Page findAllByPdtAddress(PdtDto.Page dto);
    // 글 읽기
    public PdtDto.Read findByPdtNo(PdtDto.Read dto);
    // 카테고리 검색
    public Integer findByPdtCateNo(Long pdtCateNo);
}
