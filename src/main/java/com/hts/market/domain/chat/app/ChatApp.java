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
import com.hts.market.domain.product.repo.PdtImgRepo;
import com.hts.market.domain.product.repo.PdtRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;


@Service
public class ChatApp {
    @Autowired
    ChatRepo chatRepo;
    @Autowired
    PdtRepo pdtRepo;
    @Autowired
    PdtImgRepo pdtImgRepo;

    @Autowired
    MemRepo memRepo;
    @Autowired
    MemImgRepo memImgRepo;
    // 고을호 > 서버(저장) > 김용광

    //

    public Integer save(ChatDto.Create creDto) {
        Long memNo = 1L;
        if(memNo.equals(creDto.getChatMemNo())){
            // 구매자
            creDto.setChatIsSeller(false);
        }else{
            // 판매자
            creDto.setChatIsSeller(true);
        }
        Integer result = chatRepo.save(creDto);
        Boolean result2 = result.equals(1) ? true : false;
        if (result.equals(1)) {
            return 1;
        } else {
            return 0;
        }
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
    public Integer countChatByPdtNo(Long pdtNo){
        return chatRepo.countChatByPdtNo(pdtNo);
    };

    // 상품별 관심

    public Boolean countChatByPdtNoAndMemNo (ChatDto.ChatLike chatLike) {
     Boolean like = chatRepo.countChatByPdtNoAndMemNo();
     if(like == true){
         return true;

     }
     else {
         return false;
     }
   }

    // 회원간 채팅내역
    public List<ChatDto.Read> findAllByChatMemNoAndChatPdtNo(ChatDto.ListStartEnd listStartEnd, String memUsername) {
        // 채팅 불러오기
        List<ChatDto.Read> list = chatRepo.findAllByChatMemNoAndChatPdtNo(listStartEnd);
        // 상품불러오기
        Optional<PdtDto.Detail> pdtDto = pdtRepo.findByPdtNo(listStartEnd.getChatPdtNo());
        //  MEMBER
        MemDto.Member memInfo = memRepo.findByName(memUsername).orElseThrow(()->new MemberNotFoundException());
        // Dto 패키징
       ChatDto.ChatUserInfo chatUserInfo = ChatDto.ChatUserInfo.builder().member(memInfo).product(null).chat(list).build();

        if(list.size()==0){
//             채팅내역이 없습니다.
            throw new ChatListNotFoundException();
        }else{
            // 채팅 내역이 있음.
            return list;
        }

    }

}
