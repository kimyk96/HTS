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


    // 회원 채팅방 내역 불러오기
    @GetMapping("find-by-chat-mem-no")
    public ResponseEntity<List<ChatDto.Read>> findByChatMemNo(ChatListDto.ListDto listDto) {
        List<ChatDto.Read> messageList =  chatApp.findByChatMemNo(listDto);
        return ResponseEntity.ok().body(messageList);
    }

    //채팅내역 불러오기
    @GetMapping("find-all-by-chat-mem-no-and-chat-pdt-no")
    public ResponseEntity<List<ChatDto.Read>> findAllByChatMemNoAndChatPdtNo(ChatListDto.ListDto listDto) {
        List<ChatDto.Read> messageList =  chatApp.findAllByChatMemNoAndChatPdtNo(listDto);
        return ResponseEntity.ok().body(messageList);
    }


    //최근메세지 보여주기
    @GetMapping("find-all-by-chat-mem-no-and-chat-pdt-no-and-chat-msg-no")
    public ResponseEntity<List<ChatDto.Read>> findAllByChatMemNoAndChatPdtNoAndChatMsgNo(ChatListDto.ListDto listDto) {
        List<ChatDto.Read> messageList =  chatApp.findAllByChatMemNoAndChatPdtNoAndChatMsgNo(listDto);
        return ResponseEntity.ok().body(messageList);
    }


    ;
}
