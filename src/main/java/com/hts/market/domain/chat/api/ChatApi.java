package com.hts.market.domain.chat.api;


import com.hts.market.domain.chat.app.ChatApp;
import com.hts.market.domain.chat.dto.ChatDto;
import com.hts.market.domain.member.repo.MemRepo;
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
    public ResponseEntity<Integer> save(ChatDto.Create creDto, Principal principal) {
        Integer sendMessage = chatApp.save(creDto, principal.getName());
        return ResponseEntity.ok().body(sendMessage);
    }


    // 회원 채팅방 및 최근 메세지
    @GetMapping("list")
    public ResponseEntity<List<ChatDto.Pk>> findAllByChatMemNo(Principal principal) {
        List<ChatDto.Pk> chatList = chatApp.findAllByChatMemNo(principal.getName());
        return ResponseEntity.ok().body(chatList);
    }

    // 회원간 채팅내역
    @GetMapping("")
    public ResponseEntity<ChatDto.ChatUserInfo> findAllByChatMemNoAndChatPdtNo(ChatDto.ListStartEnd listStartEnd, Principal principal) {
        ChatDto.ChatUserInfo messageList = chatApp.findAllByChatMemNoAndChatPdtNo(listStartEnd, principal.getName());
        return ResponseEntity.ok().body(messageList);
    }

    //상품별 채팅 수
    @GetMapping("count-chat-by-pdt-no")
    public ResponseEntity<Integer> countChatByPdtNo(Long chatPdtNo) {
        Integer countMemNo = chatApp.countChatByPdtNo(chatPdtNo);
        return ResponseEntity.ok().body(countMemNo);
    }

    ;

    // 상품별 관심
    @GetMapping("count-chat-by-pdt-no-and-mem-no")
    public ResponseEntity<Boolean> countChatByPdtNoAndMemNo(ChatDto.ChatLike chatLike) {
        boolean count = chatApp.countChatByPdtNoAndMemNo(chatLike);
        return ResponseEntity.ok().body(count);
    }

    ;

}
