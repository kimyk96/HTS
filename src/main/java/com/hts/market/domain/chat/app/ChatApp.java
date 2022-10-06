package com.hts.market.domain.chat.app;

import com.hts.market.domain.chat.dto.ChatDto;
import com.hts.market.domain.chat.exception.ChatListNotFoundException;
import com.hts.market.domain.chat.repo.ChatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ChatApp {
    @Autowired
    ChatRepo chatRepo;

    // 고을호 > 서버(저장) > 김용광

    public Integer save(ChatDto.Create creDto) {
        // 사용자 채팅 정보 -> DB 저장
        Integer result = chatRepo.save(creDto);
//        Boolean result2 = result.equals(1) ? true : false;
        if (result.equals(1)) {
            // DB 에 저장이 성공했으면 -> 상대방한테 채팅을 보내줘야되고
            // 웹소켓
            return 1;
        } else {
            // DB 에 저장이 실패했으면 -> 보낸사람한테 실패 메세지를 보내줘야되지.
            return 0;
        }

    }


// 웹사이트 내에서 채팅 창을 켰어 > 메세지를 보여줘야되는데 > ajax() -> 서버에 요청 (채팅내역(회원번호, 채팅번호, 상품번호))


//    //채팅방 내역
//    public List<ChatDto.Read> findByChatMemNo(ChatDto.PK pk) {
//        List<Integer> result = chatRepo.findByChatMemNo(pk);
//        if(result.size()==0){
//            // 채팅내역이 없습니다.
//            throw new ChatListNotFoundException();
//        }else{
//            // 채팅 내역이 있음.
//            return result;
//        }
//    }
//
//
//    // 마지막 메세지 출력
//    public String findAllByChatMemNoAndChatPdtNo(ChatDto.PK pk) {
//        String message = chatRepo.findAllByChatMemNoAndChatPdtNo(pk);
//        if(message.equals(0)){
//            // 채팅내역이 없습니다.
//            throw new ChatListNotFoundException();
//        }else{
//            // 채팅 내역이 있음.
//            return message;
//        }
//    }
//
//
//    //채팅내역
//    public List<ChatDto.Read> findAllByChatMemNoAndChatPdtNoAndChatMsgNo(ChatListDto.ListDto listDto) {
//        List<ChatDto.Read> list = chatRepo.findAllByChatMemNoAndChatPdtNoAndChatMsgNo(listDto);
//        if(list.size()==0){
//            // 채팅내역이 없습니다.
//            throw new ChatListNotFoundException();
//        }else{
//            // 채팅 내역이 있음.
//            return list;
//        }
//    }

}
