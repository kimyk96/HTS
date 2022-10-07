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


    // 회원 채팅방 목록 및 메세지 불러오기
//    @GetMapping("find-by-chat-mem-no")
//    public ResponseEntity<List<Integer>> findAllByChatMemNo(Long chatMemNo) {
//        List<Integer> chatList =  chatApp.findByChatMemNo(chatMemNo);
//        return ResponseEntity.ok().body(chatList);
//    }
//
    // 회원간 채팅내역
    @GetMapping("find-all-by-chat-mem-no-and-chat-pdt-no")
    public ResponseEntity<List<ChatDto.Read>> findAllByChatMemNoAndChatPdtNo(ChatDto.scroll scroll) {
        List<ChatDto.Read> messageList =  chatApp.findAllByChatMemNoAndChatPdtNo(scroll);
        return ResponseEntity.ok().body(messageList);
    }

}
