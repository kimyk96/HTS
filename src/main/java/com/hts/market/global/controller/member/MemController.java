package com.hts.market.global.controller.member;

import com.hts.market.domain.member.entity.MemEntity;
import com.hts.market.domain.member.repo.MemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@RequestMapping("member")
public class MemController {

    @Autowired
    MemRepo memRepo;

    @GetMapping("")
    public String member(){
        return "member/member";
    }

    @GetMapping("address")
    public String address(){
        return "member/address";
    }
}
