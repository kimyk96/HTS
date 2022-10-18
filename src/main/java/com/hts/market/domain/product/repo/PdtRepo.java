package com.hts.market.domain.product.repo;


import com.hts.market.domain.product.dto.PdtDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PdtRepo {
    // 판매글 작성
    public Integer save(PdtDto.Create dto);
    // 판매글 수정
    public Integer update(PdtDto.Update dto);
    // 글 읽기
    public Optional<PdtDto.Detail> findByPdtNo(Long pdtNo);
    // 조회수 증가
    public Integer increaseView(Long pdtNo,Long memNo);
    // 회원별 글목록
    public List<PdtDto.ReadList> findAllByData(PdtDto.ListData dto);
    // 판매글 삭제
    public Integer delete(PdtDto.Delete dto);
//    // 키워드 검색
//    public List<PdtDto.ReadList> searchByKeywordLike(PdtDto.SearchData dto);
    // 판매자 찾기
    public Long findSellerNoById(Long pdtNo);
}
