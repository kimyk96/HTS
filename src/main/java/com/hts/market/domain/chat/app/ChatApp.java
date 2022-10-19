package com.hts.market.domain.chat.app;

import com.hts.market.domain.chat.dto.ChatDto;
import com.hts.market.domain.chat.exception.ChatListNotFoundException;
import com.hts.market.domain.chat.repo.ChatRepo;
import com.hts.market.domain.member.dto.MemDto;
import com.hts.market.domain.member.dto.MemImgDto;
import com.hts.market.domain.member.exception.MemberNotFoundException;
import com.hts.market.domain.member.repo.MemImgRepo;
import com.hts.market.domain.member.repo.MemRepo;
import com.hts.market.domain.product.dto.PdtDto;
import com.hts.market.domain.product.exception.ProductNotFoundException;
import com.hts.market.domain.product.exception.SellerNotFoundException;
import com.hts.market.domain.product.repo.PdtImgRepo;
import com.hts.market.domain.product.repo.PdtRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class ChatApp {
    @Autowired
    ChatRepo chatRepo;
    @Autowired
    PdtRepo pdtRepo;
    @Autowired
    MemRepo memRepo;
    @Autowired
    PdtImgRepo pdtImgRepo;

    @Value("${hts.imgUrl}")
    private String imgUrl;


    // 메세지보내기
    public Integer save(ChatDto.Create creDto, String username) {
        Long sellerNo = pdtRepo.findSellerNoById(creDto.getChatPdtNo());
        Long memNo = memRepo.findIdByMemUsername(username);

        if (memNo.equals(sellerNo)) {
            // 판매자
            creDto.setChatIsSeller(1);
        } else {
            // 구매자
            creDto.setChatIsSeller(0);
        }
        return chatRepo.save(creDto);

    }

    // 회원 채팅방 목록 및 메세지 불러오기
    public List<ChatDto.Pk> findAllByUser(String username) {

        Long memNo = memRepo.findIdByMemUsername(username);
        List<ChatDto.Pk> seller = chatRepo.findAllAsSeller(memNo);
        List<ChatDto.Pk> buyer = chatRepo.findAllAsBuyer(memNo);
        List<ChatDto.Pk> allUser = new ArrayList<ChatDto.Pk>();
        seller.stream().forEach((ChatDto.Pk item) -> {
            item.setMember(memRepo.findById(item.getChatMemNo()).orElseThrow(() -> new MemberNotFoundException()));
            item.getMember().setImgPath(imgUrl + item.getMember().getImgPath());
            item.setPdtImg(imgUrl + pdtImgRepo.findMainImg(item.getChatPdtNo()));
            allUser.add(item);
        });
        buyer.stream().forEach((ChatDto.Pk item) -> {
            item.setMember(memRepo.findById(pdtRepo.findSellerNoById(item.getChatPdtNo())).orElseThrow(() -> new SellerNotFoundException()));
            item.getMember().setImgPath(imgUrl + item.getMember().getImgPath());
            item.setPdtImg(imgUrl + pdtImgRepo.findMainImg(item.getChatPdtNo()));
            allUser.add(item);
        });
        return allUser;
    }

    //상품별 채팅 수
    public Integer countChatByPdtNo(Long chatPdtNo) {
        return chatRepo.countChatByPdtNo(chatPdtNo);
    }

    ;

    // 상품별 관심

    public Boolean countChatByPdtNoAndMemNo(ChatDto.ChatLike chatLike) {
        Boolean result = chatRepo.countChatByPdtNoAndMemNo(chatLike);
        if (chatLike.getChatMemNo() == chatLike.getChatPdtNo()) {
            return true;
        } else {
            return false;
        }
    }

    // 회원간 채팅내역
    public ChatDto.ChatUserInfo findAllByChatMemNoAndChatPdtNo(ChatDto.ListStartEnd listStartEnd, String memUsername) {
        // 채팅 불러오기
        List<ChatDto.Read> list = chatRepo.findAllByChatMemNoAndChatPdtNo(listStartEnd);
        if (list.size() == 0) {
            //             채팅내역이 없습니다.
            throw new ChatListNotFoundException();
        }
        // 상품불러오기
        PdtDto.Detail pdtDto = pdtRepo.findByPdtNo(listStartEnd.getChatPdtNo()).orElseThrow(() -> new ProductNotFoundException());
        // 판매자정보 추가
        pdtDto.setMember(memRepo.findById(pdtDto.getProduct().getPdtSellerNo()).orElseThrow(() -> new SellerNotFoundException()));
        //  로그인회원 정보
        MemDto.Member memInfo = memRepo.findByName(memUsername).orElseThrow(() -> new MemberNotFoundException());
        //이미지 경로 불러오기
        pdtDto.getImages().get(0).setImgPath(imgUrl + pdtDto.getImages().get(0).getImgPath());
        memInfo.setImgPath(imgUrl + memInfo.getImgPath());


        // Dto 패키징
        return ChatDto.ChatUserInfo.builder().member(memInfo).product(pdtDto).chat(list).build();


    }

}
