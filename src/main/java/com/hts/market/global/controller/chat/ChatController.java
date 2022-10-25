package com.hts.market.global.controller.chat;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("chat")
@Secured("ROLE_USER")
public class ChatController {
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
}
