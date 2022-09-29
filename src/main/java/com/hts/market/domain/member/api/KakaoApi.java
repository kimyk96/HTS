package com.hts.market.domain.member.api;

import com.hts.market.domain.member.app.KakaoApp;
import com.hts.market.domain.member.app.MemApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/api/v1/kakao")
public class KakaoApi {
    @Autowired KakaoApp kakaoApp;
    @Autowired MemApp memApp;

    @GetMapping("")
    public ModelAndView kakaoLogin(@RequestParam String code){
        String accessToken = kakaoApp.getAccessToken(code);
        System.out.println(accessToken);
        Object memberInfo = kakaoApp.getMemberInfo(code, accessToken);
        System.out.println(memberInfo);

        // 넘어온 인증정보로 회원가입 실행


        // 카카오 로그인 정보 -> 테이블 확인 
        //      -> 미가입 = 프로젝트 멤버 테이블에 저장
        //      -> 가입됨 = 정보갱신 & 사용자 데이터 등록
        return new ModelAndView("member/login/addInfo").addObject(memberInfo);
    }

    @GetMapping("/logout")
    public ResponseEntity<String> kakaoLogout(){
        return ResponseEntity.ok().body(null);
    }
}