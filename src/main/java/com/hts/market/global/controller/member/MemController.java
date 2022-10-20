package com.hts.market.global.controller.member;

import com.hts.market.domain.member.entity.MemEntity;
import com.hts.market.domain.member.repo.MemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@RequestMapping("member")
@Secured("ROLE_USER")
public class MemController {
    @Autowired MemRepo memRepo;

    @GetMapping("")
    public String member(){
        return "member/member";
    }

    @GetMapping("{memNo}")
    public ModelAndView profile(@PathVariable Long memNo, Principal principal){
        if(memNo.equals(memRepo.findIdByMemUsername(principal.getName()))){
            return new ModelAndView("member/member");
        }else{
            return new ModelAndView("member/member_other").addObject("memNo", memNo);
        }
    }

    @GetMapping("address")
    public String address(){
        return "member/member_address";
    }

    @GetMapping("address-list")
    public String addressList(){
        return "member/member_address_list";
    }

    @GetMapping("profile")
    public String profile(){
        return "member/member_profile";
    }

    @GetMapping("favorite")
    public String favorite(){
        return "member/member_favorite";
    }
}
