package com.hts.market.domain.member.api.advice;

import com.hts.market.domain.member.exception.*;
import com.hts.market.global.config.security.auth.MemDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class MemApiAdvice {
    @Autowired MemDetailsService memDetailsService;

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<String> usernameNotFoundExceptionHandler() {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("해당 유저명을 가진 유저를 찾을 수 없습니다.");
    }
    @ExceptionHandler(NicknameAlreadyTakenException.class)
    public ResponseEntity<String> nicknameAlreadyTakenExceptionHandler() {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 사용된 닉네임입니다.");
    }
    @ExceptionHandler(EmailAlreadyTakenException.class)
    public ResponseEntity<String> emailAlreadyTakenExceptionHandler() {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 사용된 이메일입니다.");
    }
    @ExceptionHandler(PhoneAlreadyTakenException.class)
    public ResponseEntity<String> phoneAlreadyTakenExceptionHandler() {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 사용된 전화번호입니다.");
    }
    @ExceptionHandler(KakaoMemberAlreadyExsistException.class)
    public void kakaoMemberAlreadyExsistExceptionHandler(HttpServletResponse response, KakaoMemberAlreadyExsistException e) throws IOException {
        UserDetails user = memDetailsService.loadUserByUsername(e.getUsername());
        Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
        response.sendRedirect("/loginTest?msg=" + URLEncoder.encode("이미 가입된 회원입니다.", "utf-8"));
    }
    @ExceptionHandler(MemberAlreadyExsistException.class)
    public void memberAlreadyExsistExceptionHandler(HttpServletResponse response) throws IOException {
        response.sendRedirect("/login?msg=" + URLEncoder.encode("이미 가입된 회원입니다.", "utf-8"));
        // 로그인 창으로
//        return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 가입된 회원입니다.");
    }
    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<String> memberNotFoundExceptionHandler() {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("회원을 찾을 수 없습니다.");
    }
    @ExceptionHandler(MemberRoleNotFoundException.class)
    public ResponseEntity<String> memberRoleNotFoundExceptionHandler() {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("회원권한을 찾을 수 없습니다.");
    }
    @ExceptionHandler(MemberReachReportLimitException.class)
    public ResponseEntity<String> memberReachReportLimitExceptionHandler() {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("신고할 수 있는 최대 횟수에 도달 했습니다.");
    }
    @ExceptionHandler(ReportTargetNotFoundException.class)
    public ResponseEntity<String> reportTargetNotFoundExceptionHandler() {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("신고대상을 찾을 수 없습니다.");
    }
    @ExceptionHandler(MemberImageSaveFailException.class)
    public ResponseEntity<String> memberImageSaveFailExceptionHandler() {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("회원이미지 저장에 실패했습니다.");
    }
}
