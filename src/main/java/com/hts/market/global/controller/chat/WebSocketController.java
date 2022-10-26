package com.hts.market.global.controller.chat;

import com.hts.market.global.app.WebSocketApp;
import com.hts.market.global.dto.MessageDto;
import com.hts.market.global.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


@Controller
public class WebSocketController {
    @Autowired private WebSocketApp webSocketApp;

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public MessageDto send(Message message) throws Exception {
        return webSocketApp.send(message);
    }
}
