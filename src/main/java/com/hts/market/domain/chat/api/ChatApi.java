package com.hts.market.domain.chat.api;


import com.hts.market.domain.chat.app.ChatApp;
import com.hts.market.domain.chat.dto.ChatDto;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired ChatApp chatApp;

    // 채팅 조회
    @GetMapping("")
    public ResponseEntity<ChatDto.ChatUserInfo> findChat(ChatDto.ListStartEnd listStartEnd, Principal principal) {
        return ResponseEntity.ok().body(chatApp.findAllByChatMemNoAndChatPdtNo(listStartEnd, principal.getName()));
    }

    // 채팅 리스트 조회
    @GetMapping("list")
    public ResponseEntity<List<ChatDto.Pk>> findChatList(Principal principal) {
        return ResponseEntity.ok().body(chatApp.findAllByUser(principal.getName()));
    }

    // 채팅 저장
    @PostMapping("")
    public ResponseEntity<Integer> save(ChatDto.Create creDto, Principal principal) {
        return ResponseEntity.ok().body(chatApp.save(creDto, principal.getName()));
    }

    // 상품 채팅수
    @GetMapping("count-chat-by-pdt-no")
    public ResponseEntity<Integer> countChatByPdtNo(Long chatPdtNo) {
        return ResponseEntity.ok().body(chatApp.countChatByPdtNo(chatPdtNo));
    }

    // 상품 채팅여부
    @GetMapping("count-chat-by-pdt-no-and-mem-no")
    public ResponseEntity<Boolean> countChatByPdtNoAndMemNo(ChatDto.ChatLike chatLike) {
        return ResponseEntity.ok().body(chatApp.countChatByPdtNoAndMemNo(chatLike));
    }
}
