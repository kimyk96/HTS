package com.hts.market.global.controller.chat;

import com.hts.market.domain.chat.app.ChatApp;
import com.hts.market.global.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("chat")
@Secured("ROLE_USER")
public class ChatController {
    @Autowired private ChatApp chatApp;
    @Autowired private SimpMessagingTemplate simpMessagingTemplate;

    // 채팅 목록
    @GetMapping("")
    public String chat() {
        return "chat/chat";
    }

    // 채팅 방
    @GetMapping("room")
    public String chatroom() {
        return "chat/chatroom";
    }

    @MessageMapping("/{chatPdtNo}/{chatMemNo}")
    public void simple(Message message, @DestinationVariable("chatPdtNo") String chatPdtNo, @DestinationVariable("chatMemNo") String chatMemNo) {
        simpMessagingTemplate.convertAndSend("/topic/" + chatPdtNo + "/" + chatMemNo, chatApp.send(message, chatPdtNo, chatMemNo));
    }
}
