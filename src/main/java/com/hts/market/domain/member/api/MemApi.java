package com.hts.market.domain.member.api;

import com.hts.market.domain.member.app.MemApp;
import com.hts.market.domain.member.dto.MemDto;
import com.hts.market.domain.member.repo.MemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@Validated
@RequestMapping("/api/v1/mem")
public class MemApi {
    @Autowired MemApp memApp;

    // 새로 추가된 메소드

    // 인증된 전화번호 추가
    @PatchMapping("update-mem-phone-by-id")
    public ResponseEntity<Integer> updateMemPhoneById(MemDto.UpdatePhone dto) {
        return ResponseEntity.ok().body(memApp.updateMemPhoneById(dto));
    }

    // 임시 회원가입 (전화번호만 입력)
    @GetMapping("save-temp")
    public void saveTemp(MemDto.CreateTemp dto, HttpServletResponse response) throws IOException {
        memApp.saveTemp(dto);
        response.sendRedirect("/verifyPhone?memNo=" + dto.getMemNo().toString());
    }

    
    
    
    // 이하 설계도에 있는 메소드들
    
    // 회원가입
    @PostMapping("save")
    public ResponseEntity<Integer> save(MemDto.Create dto){
        return ResponseEntity.ok().body(memApp.save(dto));
    }

    // 회원 조회
    @GetMapping("find-by-id")
    public ResponseEntity<MemDto.Read> findById(Long memNo){
        return ResponseEntity.ok().body(memApp.findById(memNo));
    }

    // 회원 조회
    @GetMapping("find-by-mem-username")
    public ResponseEntity<MemDto.Read> findByMemUsername(String memUsername){
        return ResponseEntity.ok().body(memApp.findByMemUsername(memUsername));
    }

    // 회원 수정
    @PutMapping("update")
    public ResponseEntity<Integer> update(MemDto.Update dto){
        return ResponseEntity.ok().body(memApp.update(dto));
    }

    // 회원 삭제
    @DeleteMapping("delete")
    public ResponseEntity<Integer> delete(Long memNo){
        return ResponseEntity.ok().body(memApp.delete(memNo));
    }

    // 회원명 중복검사
    @GetMapping("count-by-mem-username")
    public ResponseEntity<Integer> countByMemUsername(String memUsername) {
        return ResponseEntity.ok().body(memApp.countByMemUsername(memUsername));
    }

    // 이메일 중복검사
    @GetMapping("count-by-mem-email")
    public ResponseEntity<Integer> countByMemEmail(String memEmail) {
        return ResponseEntity.ok().body(memApp.countByMemEmail(memEmail));
    }

    // 닉네임 중복검사
    @GetMapping("count-by-mem-nickname")
    public ResponseEntity<Integer> countByMemNickname(String memNickname) {
        return ResponseEntity.ok().body(memApp.countByMemNickname(memNickname));
    }

    // 전화번호 중복검사
    @GetMapping("count-by-mem-phone")
    public ResponseEntity<Integer> countByMemPhone(Integer memPhone) {
        return ResponseEntity.ok().body(memApp.countByMemPhone(memPhone));
    }

    // 비밀번호 변경
    @PatchMapping("update-mem-password")
    public ResponseEntity<Integer> updateMemPassword(MemDto.Update dto) {
        return ResponseEntity.ok().body(memApp.updateMemPassword(dto));
    }

    // 당도 조회
    @GetMapping("find-mem-brix-by-id")
    public ResponseEntity<Integer> findMemBrixById(Long memNo) {
        return ResponseEntity.ok().body(memApp.findMemBrixById(memNo));
    }

}
