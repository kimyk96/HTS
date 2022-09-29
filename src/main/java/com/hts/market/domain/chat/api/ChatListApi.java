package com.hts.market.domain.chat.api;


import com.hts.market.domain.chat.app.ChatListApp;
import com.hts.market.domain.chat.dto.ChatDto;
import com.hts.market.domain.chat.dto.ChatListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatListApi {
    @Autowired ChatListApp chatListApp;

    public ResponseEntity<Integer> save(ChatListDto chatListDto){
        Integer chatListList = chatListApp.save(chatListDto);
        return ResponseEntity.ok().body(chatListList);
    };

    public ResponseEntity<List<ChatDto.Read>> findAllByPage(String username){
        List<ChatDto.Read> chatGroup = chatListApp.findAllByPage(username);
        return ResponseEntity.ok().body(chatGroup);
    }

    public ResponseEntity<Integer> delete(Integer chatNo){
        Integer deleteChat = chatListApp.delete(chatNo);
        return ResponseEntity.ok().body(deleteChat);
    }
}
