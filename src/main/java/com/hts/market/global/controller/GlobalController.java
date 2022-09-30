package com.hts.market.global.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GlobalController {
    @GetMapping("/")
    public String start(){
        return "member/start_view";
    }
}
