package com.hts.market.domain.product.app;

import com.hts.market.domain.member.dto.MemDto;
import com.hts.market.domain.member.exception.MemberNotFoundException;
import com.hts.market.domain.member.repo.MemRepo;
import com.hts.market.domain.product.dto.PdtDto;
import com.hts.market.domain.product.exception.ProductNotFoundException;
import com.hts.market.domain.product.repo.PdtRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PdtApp {
    @Autowired
    private PdtRepo pdtRepo;
    @Autowired
    private MemRepo memRepo;

    // 판매글 작성
    public Integer save(PdtDto.Create dto, String memUsername) {
        dto.setPdtSellerNo(memRepo.findIdByMemUsername(memUsername));
        return pdtRepo.save(dto);
    }

    // 판매글 수정
    public Integer update(PdtDto.Update dto){
        return pdtRepo.update(dto);
    }

    // 글 읽기 - 관심수, 조회수 처리
    public PdtDto.Detail findByPdtNo(Long pdtNo, String memUserName) {
        PdtDto.Detail dto = pdtRepo.findByPdtNo(pdtNo).orElseThrow(()->new ProductNotFoundException());
        MemDto.Member member = memRepo.findByName(memUserName).orElseThrow(()->new MemberNotFoundException());
        dto.setMember(member);
        pdtRepo.increaseView(pdtNo, member.getMemNo());
        return dto;
    }

    // 판매글 삭제
    public Integer delete(PdtDto.Delete dto){
       return pdtRepo.delete(dto);
    }

    // 판매자별 글목록 - 관심수, 조회수 처리
    public List<PdtDto.ReadList> findAllByPdtAddress(PdtDto.AddressData dto){
        return pdtRepo.findAllByAddress(dto);
    }



    // 키워드 검색
    public List<PdtDto.ReadList> findByPdtKeywordLike(PdtDto.SearchData dto){
        return pdtRepo.searchByKeywordLike(dto);
    }

    public Long findPdtSellerNo(Long pdtSellerNo) {
        return pdtRepo.findSellerNoById(pdtSellerNo);
    }
}
