package com.hts.market.domain.product.app;

import com.hts.market.domain.chat.dto.ChatDto;
import com.hts.market.domain.chat.repo.ChatRepo;
import com.hts.market.domain.member.dto.MemDto;
import com.hts.market.domain.member.exception.MemberNotFoundException;
import com.hts.market.domain.member.repo.MemRepo;
import com.hts.market.domain.product.dto.PdtDto;
import com.hts.market.domain.product.dto.PdtFavoriteDto;
import com.hts.market.domain.product.dto.PdtImgDto;
import com.hts.market.domain.product.exception.ProductNotFoundException;
import com.hts.market.domain.product.repo.PdtFavoriteRepo;
import com.hts.market.domain.product.repo.PdtImgRepo;
import com.hts.market.domain.product.repo.PdtRepo;
import com.hts.market.domain.product.repo.PdtRptRepo;
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
    @Autowired
    private PdtImgRepo pdtImgRepo;
    @Autowired
    private PdtRptRepo pdtRptRepo;
    @Autowired
    private ChatRepo chatRepo;
    private PdtStatus pdtStatus;
    @Value("${hts.imgUrl}") private String imgUrl;

    // 판매글 작성
    public Integer save(PdtDto.Create dto, String memUsername) {
        dto.setPdtSellerNo(memRepo.findIdByMemUsername(memUsername));
        return pdtRepo.save(dto);
    }

    // 판매글 수정
    public Integer update(PdtDto.Update dto, String userName){
        dto.setPdtSellerNo(memRepo.findIdByMemUsername(userName));
        return pdtRepo.update(dto);
    }

    // 글 읽기 - 관심수, 조회수 처리
    public PdtDto.Detail findByPdtNo(Long pdtNo, String userName) {
        // 상품 정보
        PdtDto.Detail dto = pdtRepo.findByPdtNo(pdtNo).orElseThrow(()->new ProductNotFoundException());
        for(PdtImgDto.Read read : dto.getImages()){
            read.setImgPath(imgUrl + read.getImgPath());
        }

        // 회원정보
        MemDto.Member member = memRepo.findById(dto.getProduct().getPdtSellerNo()).orElseThrow(()->new MemberNotFoundException());
        member.setImgPath(imgUrl+member.getImgPath());
        dto.setMember(member);

        // 판매내역
        List<PdtDto.ReadList> sellerList = pdtRepo.findAllByData(PdtDto.ListData.builder()
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
        List<PdtDto.ReadList> cateList = pdtRepo.findAllByData(PdtDto.ListData.builder()
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

        pdtRepo.increaseView(pdtNo, memRepo.findIdByMemUsername(userName));

        // 관심수
        dto.getProduct().setFavoriteCount(pdtFavoriteRepo.countByPdtNo(pdtNo));

        // 관심체크
        dto.getProduct().setFavoriteCheck(pdtFavoriteRepo.active(dto.getProduct().getPdtNo(), dto.getMember().getMemNo()));

        return dto;
    }

    // 판매글 삭제
    public Integer delete(Long pdtNo, String userName){
        pdtRepo.delete(
                PdtDto.Delete
                        .builder()
                        .pdtNo(pdtNo)
                        .pdtSellerNo(memRepo.findIdByMemUsername(userName))
                        .build());
        pdtFavoriteRepo.delete(
                PdtFavoriteDto.Delete
                        .builder()
                        .pdtNo(pdtNo)
                        .memNo(memRepo.findIdByMemUsername(userName))
                        .build());
        pdtImgRepo.deleteAll(pdtNo);
        pdtRptRepo.deleteByRptPdtNo(pdtNo);
        return 1;
    }

    // 판매자별 글목록
    public List<PdtDto.ReadList> findAllByData(PdtDto.ListData dto, String userName){
        List<PdtDto.ReadList> list = pdtRepo.findAllByData(dto);
        Long memNo = memRepo.findIdByMemUsername(userName);
        for(PdtDto.ReadList pdt : list){
            pdt.setImgPath(imgUrl + pdt.getImgPath());
            // 관심수
            pdt.setFavoriteCount(pdtFavoriteRepo.countByPdtNo(pdt.getPdtNo()));
            // 관심체크
            pdt.setFavoriteCheck(pdtFavoriteRepo.active(pdt.getPdtNo(),memNo));
            // 채팅수
            pdt.setChatCount(chatRepo.countChatByPdtNo(pdt.getPdtNo()));
            // 채팅체크
            pdt.setChatCheck(chatRepo.countChatByPdtNoAndMemNo(ChatDto.ChatLike.builder().chatPdtNo(pdt.getPdtNo()).chatMemNo(memNo).build()));
        }
        return list;
    }


    // 판자번호 조회
    public Long findPdtSellerNo(Long pdtSellerNo) {
        return pdtRepo.findSellerNoById(pdtSellerNo);
    }
}

enum PdtStatus {
    판매중, 거래중, 판매완료
}
