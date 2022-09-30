package com.hts.market.domain.member.api;

import com.hts.market.domain.member.app.KakaoApp;
import com.hts.market.domain.member.app.MemApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
@Validated
@RequestMapping("/api/v1/kakao")
public class KakaoApi {
    @Autowired KakaoApp kakaoApp;
    @GetMapping("")
    public void kakaoSignup(@RequestParam String code, HttpServletResponse response) throws IOException {
        Long memNo = kakaoApp.save(code);
        response.sendRedirect("/verifyPhone?memNo=" + memNo);
    }
    @GetMapping("/logout")
    public ResponseEntity<String> kakaoLogout(){
        return ResponseEntity.ok().body(null);
    }
}