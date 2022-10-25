package com.hts.market.domain.member.api;

import com.hts.market.domain.member.app.KakaoApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@Validated
@RequestMapping("/api/v1/kakao")
public class KakaoApi {
    @Autowired KakaoApp kakaoApp;

    // 카카오 인증
    @GetMapping("")
    public void save(@RequestParam String code, HttpServletResponse response) throws IOException {
        response.sendRedirect("/login?memNo=" + kakaoApp.save(code));
    }
}