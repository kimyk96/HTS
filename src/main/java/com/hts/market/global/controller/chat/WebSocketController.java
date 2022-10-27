package com.hts.market.global.controller.chat;

import com.hts.market.domain.chat.app.ChatApp;
import com.hts.market.global.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;


@Controller
public class WebSocketController {
    @Autowired private ChatApp chatApp;
    @Autowired private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat/{chatPdtNo}/{chatMemNo}")
    public void simple(Message message, @DestinationVariable("chatPdtNo") String chatPdtNo, @DestinationVariable("chatMemNo") String chatMemNo) {
        simpMessagingTemplate.convertAndSend("/topic/" + chatPdtNo + "/" + chatMemNo, chatApp.send(message, chatPdtNo, chatMemNo));
    }
}
