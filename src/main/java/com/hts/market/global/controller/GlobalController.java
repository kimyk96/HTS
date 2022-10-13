package com.hts.market.global.controller;

import com.hts.market.domain.member.entity.MemEntity;
import com.hts.market.domain.member.repo.MemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class GlobalController {

    @Autowired
    MemRepo memRepo;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/signup")
    public ModelAndView signup(Principal principal){
        MemEntity member = memRepo.loadUserByUsername(principal.getName());
        return new ModelAndView("signup").addObject("member", member);
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
