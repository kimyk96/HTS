package com.hts.market.domain.chat.api;


import com.hts.market.domain.chat.app.ChatApp;
import com.hts.market.domain.chat.dto.ChatDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatApi {
    @Autowired ChatApp chatApp;

    // 채팅 보내기
    public ResponseEntity<Integer> save(ChatDto.Create creDto) {
        Integer sendMessage = chatApp.save(creDto);
        return ResponseEntity.ok().body(sendMessage);
    };

    //채팅내역 불러오기
    public ResponseEntity<List<ChatDto.Read>> findAllByChatListNo(Long chatListNo) {
        List<ChatDto.Read> messageList = chatApp.findAllBychatListNo();
        return ResponseEntity.ok().body(messageList);
    };

}
