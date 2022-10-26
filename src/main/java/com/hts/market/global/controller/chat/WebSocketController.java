package com.hts.market.global.controller.chat;

import com.hts.market.global.app.WebSocketApp;
import com.hts.market.global.dto.MessageDto;
import com.hts.market.global.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;


@Controller
public class WebSocketController {
    @Autowired private WebSocketApp webSocketApp;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

//    @MessageMapping("/chat")
//    public MessageDto send(Message message, @DestinationVariable String chatPdtNo, @DestinationVariable String chatMemNo) throws Exception {
//        return webSocketApp.send(message);
//    }

    @MessageMapping("/chat/{chatPdtNo}/{chatMemNo}")
    public void simple(Message message, @DestinationVariable("chatPdtNo") String chatPdtNo, @DestinationVariable("chatMemNo") String chatMemNo) {
        simpMessagingTemplate.convertAndSend("/topic/" + chatPdtNo + "/" + chatMemNo, webSocketApp.send(message));
    }
}
