package com.hts.market.global.controller.chat;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("chat")
@Secured("ROLE_USER")
public class ChatController {
    @GetMapping("")
    public String chat(){
        return "chat/chat";
    }
    @GetMapping("room")
    public String chatroom(){
        return "chat/chatroom";
    }
}
