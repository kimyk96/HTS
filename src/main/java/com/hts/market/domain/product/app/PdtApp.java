package com.hts.market.domain.product.app;

import com.hts.market.domain.product.dto.PdtDto;
import com.hts.market.domain.product.entity.PdtEntity;
import com.hts.market.domain.product.repo.PdtRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PdtApp {
    @Autowired
    private PdtRepo pdtRepo;

    // 판매글 작성
    public PdtEntity save(PdtDto.Create dto) {
        return null;
    }
    // 판매글 수정
    public Integer update(PdtDto.Update dto){
        return null;
    }
    // 판매글 조회수 증가
    public Integer countByPdtNo(Integer views, String username){
        return null;
    }
    // 판매글 삭제
    public Integer delete(PdtDto.Delete dto){
        return null;
    }
    // 키워드 검색
    public PdtDto.SearchData findByPdtKeywordLike(PdtDto.SearchData dto){
        return null;
    }
    // 판매자명 검색
    public Integer findByPdtSellerLike(Long pdtSellerNo){
        return null;
    }
    // 판매자별 글목록
    public PdtDto.Page findAllByPdtAddress(PdtDto.Page dto){
        return null;
    }
    // 글 읽기
    public PdtDto.Read findByPdtNo(PdtDto.Read dto){
        return null;
    }
    // 카테고리 검색
    public Integer findByPdtCateNo(Long pdtCateNo){
        return null;
    }
}
