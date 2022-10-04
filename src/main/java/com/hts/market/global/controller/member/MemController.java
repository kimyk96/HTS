package com.hts.market.global.controller.member;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemController {

    @GetMapping("/verifyPhone")
    public String verifyPhone(){
        return "member/verifyPhone";
    }
    @GetMapping("/addInfo")
    public String addInfo(){
        return "member/addInfo";
    }
    @GetMapping("/login")
    public String login(){
        return "member/login";
    }
    @GetMapping("/loginTest")
    @Secured("ROLE_USER")
    public String loginTest(){
        return "member/loginTest";
    }

}
