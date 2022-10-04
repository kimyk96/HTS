package com.hts.market.domain.chat.api;


import com.hts.market.domain.chat.app.ChatApp;
import com.hts.market.domain.chat.dto.ChatDto;
import com.hts.market.domain.chat.dto.ChatListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/v1/chat")
public class ChatApi {
    @Autowired ChatApp chatApp;


    // 채팅 보내기
    @PostMapping(path = "save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> save() {
        ChatDto.Create creDto = ChatDto.Create.builder().chatMemNo(1L).chatPdtNo(1L).chatContent("안녕하세요").build();
        Integer sendMessage = chatApp.save(creDto);
        return ResponseEntity.ok().body(sendMessage);
    }


    //채팅내역 불러오기
    @GetMapping("find-all-by-chat-msg-no")
    public ResponseEntity<List<ChatDto.Read>> findAllById(ChatListDto.ListDto listDto) {
        List<ChatDto.Read> messageList =  chatApp.findAllById(listDto);
        return ResponseEntity.ok().body(messageList);
    }

    ;

}
