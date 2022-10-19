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
import com.hts.market.domain.product.repo.PdtImgRepo;
import com.hts.market.domain.product.repo.PdtRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class ChatApp {
    @Autowired
    ChatRepo chatRepo;
    @Autowired
    PdtRepo pdtRepo;
//    @Autowired
//    PdtImgRepo pdtImgRepo;

    @Autowired
    MemRepo memRepo;
//    @Autowired
//    MemImgRepo memImgRepo;
    // 고을호 > 서버(저장) > 김용광
    @Value("${hts.imgUrl}") private String imgUrl;


    // 메세지보내기
    public Integer save(ChatDto.Create creDto, String username) {
        Long sellerNo= pdtRepo.findSellerNoById(creDto.getChatPdtNo());
         Long memNo = memRepo.findIdByMemUsername(username);

        if(memNo == sellerNo){
            // 판매자
            creDto.setChatIsSeller(1);
        }else{
            // 구매자
            creDto.setChatIsSeller(0);
        }
        return chatRepo.save(creDto);

    }

    // 회원 채팅방 목록 및 메세지 불러오기
    public List<ChatDto.Pk> findAllByChatMemNo(Long chatMemNo) {
        List<ChatDto.Pk> result = chatRepo.findAllByChatMemNo(chatMemNo);
        if(result.size()==0){
            // 채팅내역이 없습니다.
            throw new ChatListNotFoundException();
        }else{
            // 채팅 내역이 있음.
            return result;
        }
    }

    //상품별 채팅 수
    public Integer countChatByPdtNo(Long chatPdtNo){
        return chatRepo.countChatByPdtNo(chatPdtNo);
    };

    // 상품별 관심

    public Boolean countChatByPdtNoAndMemNo(ChatDto.ChatLike chatLike) {
       Boolean result = chatRepo.countChatByPdtNoAndMemNo(chatLike);
       if(chatLike.getChatMemNo()==chatLike.getChatPdtNo()) {
           return true;
       }
       else{
        return false;
        }
    }

    // 회원간 채팅내역
    public ChatDto.ChatUserInfo findAllByChatMemNoAndChatPdtNo(ChatDto.ListStartEnd listStartEnd, String memUsername) {
        // 채팅 불러오기
        List<ChatDto.Read> list = chatRepo.findAllByChatMemNoAndChatPdtNo(listStartEnd);
        if(list.size()==0){
            //             채팅내역이 없습니다.
            throw new ChatListNotFoundException();
        }
        // 상품불러오기
        PdtDto.Detail pdtDto = pdtRepo.findByPdtNo(listStartEnd.getChatPdtNo()).orElseThrow(()->new ProductNotFoundException());
        //  MEMBER
        MemDto.Member memInfo = memRepo.findByName(memUsername).orElseThrow(()->new MemberNotFoundException());
        //이미지 경로 불러오기
        pdtDto.getImages().get(0).setImgPath(imgUrl + pdtDto.getImages().get(0).getImgPath());
        memInfo.setImgPath(imgUrl + memInfo.getImgPath());





        // Dto 패키징
        return ChatDto.ChatUserInfo.builder().member(memInfo).product(pdtDto).chat(list).build();



    }

}
