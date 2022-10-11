package com.hts.market.domain.product.app;

import com.hts.market.domain.product.dto.PdtDto;
import com.hts.market.domain.product.entity.PdtEntity;
import com.hts.market.domain.product.repo.PdtRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Integer countByPdtNo(PdtDto.ViewCount dto){
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
    public List<PdtDto.ReadList> findAllByPdtAddress(PdtDto.AddressData dto){
        return pdtRepo.findAllByAddress(dto);
    }
    // 글 읽기
    public Optional<PdtDto.Read> findByPdtNo(Long pdtNo) {
        return pdtRepo.findByPdtNo(pdtNo);
    }
}
