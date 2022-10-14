package com.hts.market.domain.member.api;

import com.hts.market.domain.member.app.MemApp;
import com.hts.market.domain.member.app.SmsApp;
import com.hts.market.domain.member.dto.MemDto;
import com.hts.market.domain.member.repo.MemRepo;
import com.hts.market.global.config.security.auth.MemDetails;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

@RestController
@Validated
@RequestMapping("/api/v1/mem")
public class MemApi {
    @Autowired MemApp memApp;
    @Autowired SmsApp smsApp;

    // 인증번호
    @PostMapping("code")
    public ResponseEntity<Integer> code(String memUsername, Long memNo) throws CoolsmsException {
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
    public ResponseEntity<MemDto.Member> findByName(Principal principal){
        return ResponseEntity.ok().body(memApp.findByName(principal.getName()));
    }

    @PatchMapping("update-profile")
    public ResponseEntity<Integer> updateProfileByName(MemDto.Profile dto, Principal principal){
        return ResponseEntity.ok().body(memApp.updateProfile(dto, principal.getName()));
    }

}
