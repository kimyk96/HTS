package com.hts.market.domain.member.api.advice;

import com.hts.market.domain.member.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MemApiAdvice {
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
    @ExceptionHandler(MemberAlreadyExsistException.class)
    public ResponseEntity<String> memberAlreadyExsistExceptionHandler() {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 가입된 회원입니다.");
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
