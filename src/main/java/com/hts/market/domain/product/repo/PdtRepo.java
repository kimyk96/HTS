package com.hts.market.domain.product.repo;


import com.hts.market.domain.product.dto.PdtDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PdtRepo {
    // 판매글 작성
    public Integer save(PdtDto.Create dto);
    // 판매글 수정
    public Integer update(PdtDto.Update dto);
    // 판매글 조회수 증가
    public Integer increaseInViews(PdtDto.ViewCount dto);
    // 글 읽기
    public PdtDto.Read findByPdtNo(PdtDto.Read dto);
    // 회원별 글목록
    public List<PdtDto.ReadList> findAllByAddress(PdtDto.AddressData dto);
    // 판매글 삭제
    public Integer delete(PdtDto.Delete dto);
    // 키워드 검색
    public List<PdtDto.ReadList> searchByKeywordLike(PdtDto.KeywordSearch dto);
    // 카테고리 검색
    public Integer searchByPdtCateNoLike(PdtDto.CateSearch dto);
}
