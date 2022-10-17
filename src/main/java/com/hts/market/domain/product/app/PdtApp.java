package com.hts.market.domain.product.app;

import com.hts.market.domain.member.dto.MemDto;
import com.hts.market.domain.member.exception.MemberNotFoundException;
import com.hts.market.domain.member.repo.MemRepo;
import com.hts.market.domain.product.dto.PdtDto;
import com.hts.market.domain.product.dto.PdtImgDto;
import com.hts.market.domain.product.exception.ProductNotFoundException;
import com.hts.market.domain.product.repo.PdtFavoriteRepo;
import com.hts.market.domain.product.repo.PdtRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PdtApp {
    @Autowired
    private PdtRepo pdtRepo;
    @Autowired
    private MemRepo memRepo;
    @Autowired
    private PdtFavoriteRepo pdtFavoriteRepo;

    @Value("${hts.imgUrl}") private String imgUrl;

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
        // 상품 정보
        PdtDto.Detail dto = pdtRepo.findByPdtNo(pdtNo).orElseThrow(()->new ProductNotFoundException());
        for(PdtImgDto.Read read : dto.getImages()){
            read.setImgPath(imgUrl + read.getImgPath());
        }
        // 회원정보
        MemDto.Member member = memRepo.findByName(memUserName).orElseThrow(()->new MemberNotFoundException());
        member.setImgPath(imgUrl+member.getImgPath());
        dto.setMember(member);
        // 판매내역
        List<PdtDto.ReadList> sellerList = pdtRepo.searchByKeywordLike(PdtDto.SearchData.builder()
                .pdtNo(pdtNo)
                .addressSi(dto.getAddress().getAddressSi())
                .addressGu(dto.getAddress().getAddressGu())
                .addressDong(dto.getAddress().getAddressDong())
                .start(1).end(4).pdtSellerNo(member.getMemNo())
                .build());
        for(PdtDto.ReadList read : sellerList){
            read.setImgPath(imgUrl + read.getImgPath());
        }
        dto.setSellerList(sellerList);

        // 카테고리 내역검색
        List<PdtDto.ReadList> cateList = pdtRepo.searchByKeywordLike(PdtDto.SearchData.builder()
                .pdtNo(pdtNo)
                .addressSi(dto.getAddress().getAddressSi())
                .addressGu(dto.getAddress().getAddressGu())
                .addressDong(dto.getAddress().getAddressDong())
                .start(1).end(4).pdtCate(dto.getPdtCate())
                .build());
        for(PdtDto.ReadList read : cateList){
            read.setImgPath(imgUrl + read.getImgPath());
        }
        dto.setCateList(cateList);

        pdtRepo.increaseView(pdtNo, member.getMemNo());

        // 관심수
        dto.getProduct().setFavoriteCount(pdtFavoriteRepo.countByPdtNo(pdtNo));

        // 관심체크
        dto.getProduct().setFavoriteCheck(pdtFavoriteRepo.active(dto.getProduct().getPdtNo(), dto.getMember().getMemNo()));

        return dto;
    }

    // 판매글 삭제
    public Integer delete(PdtDto.Delete dto){
       return pdtRepo.delete(dto);
    }

    // 판매자별 글목록 - 관심수, 조회수 처리
    public List<PdtDto.ReadList> findAllByPdtAddress(PdtDto.AddressData dto){
        List<PdtDto.ReadList> list = pdtRepo.findAllByAddress(dto);
        for(PdtDto.ReadList pdt : list){
            pdt.setImgPath(imgUrl + pdt.getImgPath());
        }
        return list;
    }



    // 키워드 검색
    public List<PdtDto.ReadList> findByPdtKeywordLike(PdtDto.SearchData dto){
        return pdtRepo.searchByKeywordLike(dto);
    }

    public Long findPdtSellerNo(Long pdtSellerNo) {
        return pdtRepo.findSellerNoById(pdtSellerNo);
    }
}
