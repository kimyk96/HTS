package com.hts.market.domain.chat.api;


import com.hts.market.domain.chat.app.ChatApp;
import com.hts.market.domain.chat.dto.ChatDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/v1/chat")
public class ChatApi {
    @Autowired
    ChatApp chatApp;


    // 채팅 보내기
    @PostMapping(path = "save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> save(ChatDto.Create creDto) {
        Integer sendMessage = chatApp.save(creDto);
        return ResponseEntity.ok().body(sendMessage);
    }


    // 회원 채팅방 및 최근 메세지
    @GetMapping("find-all-by-chat-mem-no")
    public ResponseEntity<List<ChatDto.Pk>> findAllByChatMemNo(Long chatMemNo) {
        List<ChatDto.Pk> chatList =  chatApp.findAllByChatMemNo(chatMemNo);
        return ResponseEntity.ok().body(chatList);
    }

    // 회원간 채팅내역
    @GetMapping("find-all-by-chat-mem-no-and-chat-pdt-no")
    public ResponseEntity<List<ChatDto.Read>> findAllByChatMemNoAndChatPdtNo(ChatDto.ListStartEnd listStartEnd, Principal principal) {
        List<ChatDto.Read> messageList =  chatApp.findAllByChatMemNoAndChatPdtNo(listStartEnd, principal.getName());
        return ResponseEntity.ok().body(messageList);
    }

    //상품별 채팅 수
    @GetMapping("count-chat-by-pdt-no")
    public ResponseEntity<Integer> countChatByPdtNo(Long pdtNo){
        Integer countMemNo = chatApp.countChatByPdtNo(pdtNo);
        return ResponseEntity.ok().body(countMemNo);
    };

    // 상품별 관심
    @GetMapping("count-chat-by-pdt-no-and-mem-no")
    public ResponseEntity<Boolean> countChatByPdtNoAndMemNo (Long chatPdtNo, Long chatMemNo){
        boolean count = chatApp.countChatByPdtNoAndMemNo(chatPdtNo, chatMemNo);
        return ResponseEntity.ok().body(count);
    };

}
