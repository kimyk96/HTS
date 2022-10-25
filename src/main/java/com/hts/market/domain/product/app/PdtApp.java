package com.hts.market.domain.product.app;

import com.hts.market.domain.chat.dto.ChatDto;
import com.hts.market.domain.chat.repo.ChatRepo;
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
    @Autowired private PdtRepo pdtRepo;
    @Autowired private MemRepo memRepo;
    @Autowired private PdtFavoriteRepo pdtFavoriteRepo;
    @Autowired private ChatRepo chatRepo;
    @Value("${hts.imgUrl}") private String imgUrl;

    // 상품 작성
    public Integer save(PdtDto.Create dto, String userName) {
        dto.setPdtSellerNo(memRepo.findIdByMemUsername(userName));
        return pdtRepo.save(dto);
    }

    // 상품 수정
    public Integer update(PdtDto.Update dto, String userName) {
        dto.setPdtSellerNo(memRepo.findIdByMemUsername(userName));
        return pdtRepo.update(dto);
    }

    // 상품 읽기
    public PdtDto.Detail findByPdtNo(Long pdtNo, String userName) {
        // 로그인 회원 번호 가져오기
        Long memNo = memRepo.findIdByMemUsername(userName);

        // 상품 정보
        PdtDto.Detail dto = pdtRepo.findByPdtNo(pdtNo).orElseThrow(ProductNotFoundException::new);
        for (PdtImgDto.Read read : dto.getImages()) {
            read.setImgPath(imgUrl + read.getImgPath());
        }

        // 회원정보
        MemDto.Member member = memRepo.findById(dto.getProduct().getPdtSellerNo()).orElseThrow(MemberNotFoundException::new);
        member.setImgPath(imgUrl + member.getImgPath());
        dto.setMember(member);

        // 판매내역
        List<PdtDto.ReadList> sellerList = pdtRepo.findAllByData(PdtDto.ListData.builder().pdtNo(pdtNo).addressSi(dto.getAddress().getAddressSi()).addressGu(dto.getAddress().getAddressGu()).addressDong(dto.getAddress().getAddressDong()).start(1).end(4).pdtSellerNo(member.getMemNo()).build());
        for (PdtDto.ReadList read : sellerList) {
            read.setImgPath(imgUrl + read.getImgPath());
        }
        dto.setSellerList(sellerList);

        // 카테고리 내역검색
        List<PdtDto.ReadList> cateList = pdtRepo.findAllByData(PdtDto.ListData.builder().pdtNo(pdtNo).addressSi(dto.getAddress().getAddressSi()).addressGu(dto.getAddress().getAddressGu()).addressDong(dto.getAddress().getAddressDong()).start(1).end(4).pdtCate(dto.getPdtCate()).build());
        for (PdtDto.ReadList read : cateList) {
            read.setImgPath(imgUrl + read.getImgPath());
        }
        dto.setCateList(cateList);

        pdtRepo.increaseView(PdtDto.ViewCount.builder().memNo(memNo).pdtNo(pdtNo).build());

        // 관심수
        dto.getProduct().setFavoriteCount(pdtFavoriteRepo.countByPdtNo(pdtNo));

        // 관심체크
        dto.getProduct().setFavoriteCheck(pdtFavoriteRepo.active(dto.getProduct().getPdtNo(), memNo));

        return dto;
    }

    // 판매글 삭제
    public Integer delete(Long pdtNo, String userName) {
        return pdtRepo.delete(PdtDto.Delete.builder().pdtNo(pdtNo).pdtSellerNo(memRepo.findIdByMemUsername(userName)).build());
    }

    // 판매자별 글목록
    public List<PdtDto.ReadList> findAllByData(PdtDto.ListData dto, String userName) {
        List<PdtDto.ReadList> list = pdtRepo.findAllByData(dto);
        Long memNo = memRepo.findIdByMemUsername(userName);
        for (PdtDto.ReadList pdt : list) {
            pdt.setImgPath(imgUrl + pdt.getImgPath());
            // 관심수
            pdt.setFavoriteCount(pdtFavoriteRepo.countByPdtNo(pdt.getPdtNo()));
            // 관심체크
            pdt.setFavoriteCheck(pdtFavoriteRepo.active(pdt.getPdtNo(), memNo));
            // 채팅수
            pdt.setChatCount(chatRepo.countChatByPdtNo(pdt.getPdtNo()));
            // 채팅체크
            pdt.setChatCheck(chatRepo.countChatByPdtNoAndMemNo(ChatDto.ChatLike.builder().chatPdtNo(pdt.getPdtNo()).chatMemNo(memNo).build()));
        }
        return list;
    }

    // 판매자번호 조회
    public Long findPdtSellerNo(Long pdtSellerNo) {
        return pdtRepo.findSellerNoById(pdtSellerNo);
    }

    // 등록한 상품 조회
    public List<PdtDto.ReadList> findAllByMemNo(String username) {
        Long memNo = memRepo.findIdByMemUsername(username);
        List<PdtDto.ReadList> list = pdtRepo.findAllByMemNo(memNo);
        list.forEach(item-> {
            item.setImgPath(imgUrl + item.getImgPath());
            item.setFavoriteCount(pdtFavoriteRepo.countByPdtNo(item.getPdtNo()));
            item.setFavoriteCheck(pdtFavoriteRepo.active(item.getPdtNo(), memNo));
            item.setChatCount(chatRepo.countChatByPdtNo(item.getPdtNo()));
            item.setChatCheck(chatRepo.countChatByPdtNoAndMemNo(ChatDto.ChatLike.builder().chatPdtNo(item.getPdtNo()).chatMemNo(memNo).build()));
        });
        return list;
    }
}