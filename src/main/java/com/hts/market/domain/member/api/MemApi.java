package com.hts.market.domain.member.api;

import com.hts.market.domain.member.app.MemApp;
import com.hts.market.domain.member.app.SmsApp;
import com.hts.market.domain.member.dto.MemDto;
import com.hts.market.domain.member.exception.MemberAlreadyExsistException;
import com.hts.market.domain.member.repo.MemRepo;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@Validated
@RequestMapping("/api/v1/mem")
public class MemApi {
    @Autowired MemApp memApp;
    @Autowired SmsApp smsApp;
    @Autowired MemRepo memRepo;

    // 인증 번호
    @PostMapping("code")
    public ResponseEntity<Integer> code(String memUsername, Long memNo) throws CoolsmsException {
        if (memNo != null && memRepo.countByMemUsername(memUsername)) {
            throw new MemberAlreadyExsistException();
        }
        // 인증번호 발송
        String code = smsApp.send(memUsername);
        // 비밀번호->인증번호로 갱신
        return ResponseEntity.ok().body(memApp.code(memUsername, code, memNo));
    }

    // 회원 전화번호 수정
    @PostMapping("update-mem-username-by-id")
    public ResponseEntity<Integer> updateMemUsernameById(String memUsername, Long memNo) {
        return ResponseEntity.ok().body(memApp.updateMemUsernameById(memUsername, memNo));
    }

    // 회원 정보 수정
    @PatchMapping("update-by-mem-username")
    public ResponseEntity<Integer> updateByMemUsername(MemDto.Update dto) {
        return ResponseEntity.ok().body(memApp.updateByMemUsername(dto));
    }

    // 회원 정보 조회
    @GetMapping("find-by-name")
    public ResponseEntity<MemDto.Member> findByName(Principal principal) {
        return ResponseEntity.ok().body(memApp.findByName(principal.getName()));
    }

    // 타 회원 정보 조회
    @GetMapping("find-by-id")
    public ResponseEntity<MemDto.Member> findById(Long memNo) {
        return ResponseEntity.ok().body(memApp.findById(memNo));
    }

    // 프로필 업데이트
    @PatchMapping("update-profile")
    public ResponseEntity<Integer> updateProfileByName(MemDto.Profile dto, Principal principal) {
        return ResponseEntity.ok().body(memApp.updateProfile(dto, principal.getName()));
    }

    // 회원명으로 회원 번호 조회
    @GetMapping("find-id-by-mem-username")
    public ResponseEntity<Long> findIdByMemUsername(Principal principal) {
        return ResponseEntity.ok().body(memApp.findIdByMemUsername(principal.getName()));
    }

    // 회원 탈퇴
    @DeleteMapping("")
    public ResponseEntity<Integer> delete(Principal principal) {
        return ResponseEntity.ok().body(memApp.delete(principal.getName()));
    }
}
