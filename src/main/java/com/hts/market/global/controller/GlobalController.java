package com.hts.market.global.controller;

import com.hts.market.domain.member.dto.MemDto;
import com.hts.market.domain.member.exception.MemberNotFoundException;
import com.hts.market.domain.member.repo.MemRepo;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.InputStream;
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
        MemDto.Member member = memRepo.findByName(principal.getName()).orElseThrow(MemberNotFoundException::new);
        return new ModelAndView("global/signup").addObject("member", member);
    }
    @GetMapping("/login")
    public String login(){
        return "global/login";
    }

    @GetMapping(
            value = "/.well-known/pki-validation/B9236581E40F1D6A3CA0427F8B646825.txt",
            produces = MediaType.APPLICATION_OCTET_STREAM_VALUE
    )
    public ResponseEntity<String> getFile() throws IOException {
        return ResponseEntity.ok().body("71781B5B0A8DA8E819C16FBEDAF5CF56143FB45F668C713E45DC773EC55DB526\n" +
                "comodoca.com\n" +
                "d4646b8e9cf7428");
    }

}
