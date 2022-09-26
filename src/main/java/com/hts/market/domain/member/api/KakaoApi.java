package com.hts.market.domain.member.api;

import com.hts.market.domain.member.app.KakaoApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/api/v1/kakao")
public class KakaoApi {
    @Autowired KakaoApp kakaoApp;

    @GetMapping("")
    public ResponseEntity<String> kakaoLogin(@RequestParam String code){
        String accessToken = kakaoApp.getAccessToken(code);
        System.out.println(accessToken);
        Object memberInfo = kakaoApp.getMemberInfo(code, accessToken);
        System.out.println(memberInfo);

        // 카카오 로그인 정보 -> 테이블 확인 
        //      -> 미가입 = 프로젝트 멤버 테이블에 저장
        //      -> 가입됨 = 정보갱신 & 사용자 데이터 등록
        return ResponseEntity.ok().body(memberInfo.toString());
    }

    @GetMapping("/logout")
    public ResponseEntity<String> kakaoLogout(){
        return ResponseEntity.ok().body(null);
    }







//    @GetMapping("/do")
//    public String loginPage()
//    {
//        return "kakaoCI/login";
//    }
//
//    @GetMapping("/kakao")
//    public String getCI(@RequestParam String code, Model model) throws IOException {
//        System.out.println("code = " + code);
//        String access_token = kakaoApp.getToken(code);
//        Map<String, Object> userInfo = kakaoApp.getUserInfo(access_token);
//        model.addAttribute("code", code);
//        model.addAttribute("access_token", access_token);
//        model.addAttribute("userInfo", userInfo);
//
//        //ci는 비즈니스 전환후 검수신청 -> 허락받아야 수집 가능
//        return "index";
//    }

}