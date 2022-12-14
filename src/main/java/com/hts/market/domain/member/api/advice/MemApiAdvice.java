package com.hts.market.domain.member.api.advice;

import com.hts.market.domain.member.exception.*;
import com.hts.market.global.config.security.auth.MemDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        if(e.getMember().getMemUsername()==null||e.getMember().getMemUsername().equals("null")){
            // 핸드폰 인증 화면으로
            response.sendRedirect("/login?memNo=" + e.getMember().getMemNo());
        }
        else if(e.getMember().getAddress().isEmpty()){
            // 주소 기입창
            response.sendRedirect("/member/address");
        }
        else{
            // 메인 화면으로
            UserDetails user = memDetailsService.loadUserByUsername(e.getMember().getMemUsername());
            Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
            response.sendRedirect("/product");
        }
    }
    @ExceptionHandler(MemberAlreadyExsistException.class)
    public ResponseEntity<String> memberAlreadyExsistExceptionHandler(HttpServletResponse response) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 가입된 번호입니다");
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
