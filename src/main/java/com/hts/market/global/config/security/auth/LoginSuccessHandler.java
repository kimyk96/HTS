package com.hts.market.global.config.security.auth;

import com.hts.market.domain.member.dto.MemDto;
import com.hts.market.domain.member.exception.MemberNotFoundException;
import com.hts.market.domain.member.repo.MemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired MemRepo memRepo;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        // 회원 정보 확인
        MemDto.Member member = memRepo.findByName(authentication.getName()).orElseThrow(MemberNotFoundException::new);

        // 리다이렉션
        if (member.getMemEmail() == null) {
            // 미기입 정보 있을 시 -> 정보 기입 페이지
            response.sendRedirect("/signup");
        } else if (member.getAddress().isEmpty()) {
            // 주소 없을 시 -> 주소 등록 창으로 이동
            response.sendRedirect("/member/address");
        } else {
            // 메인 페이지
            response.sendRedirect("/product");
        }
    }
}