package com.hts.market.domain.member.api;

import com.hts.market.domain.member.app.MemApp;
import com.hts.market.domain.member.dto.MemDto;
import com.hts.market.domain.member.repo.MemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1/mem")
public class MemApi {
    @Autowired MemApp memApp;

    // 전화번호 중복 확인
    @GetMapping("count-by-mem-phone")
    public ResponseEntity<Integer> countByMemPhone(Integer memPhone) {
        return ResponseEntity.ok().body(memApp.countByMemPhone(memPhone));
    }

    // 인증된 전화번호 추가
    @PatchMapping("update-mem-phone-by-id")
    public ResponseEntity<Integer> updateMemPhoneById(MemDto.UpdatePhone dto) {
        return ResponseEntity.ok().body(memApp.updateMemPhoneById(dto));
    }

    // 회원 정보 조회
    @GetMapping("find-by-id")
    public ResponseEntity<MemDto.Read> findById(Long memNo){
        return ResponseEntity.ok().body(memApp.findById(memNo));
    }

    // 임시 회원가입 (전화번호만 입력)
    @GetMapping("save-temp")
    public void saveTemp(MemDto.CreateTemp dto, HttpServletResponse response) throws IOException {
        memApp.saveTemp(dto);
        response.sendRedirect("/verifyPhone?memNo=" + dto.getMemNo().toString());
    }










    

//    @Autowired MemRepo memRepo;
//    @Secured("ROLE_USER")
//    @GetMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Integer> saveTest(){
//        MemDto.Create dto = MemDto.Create.builder().memName("김용광").memEmail("kimyk96@gmail.com").memNickname("용팡").memPassword("12341234").memPhone(1027249409).memUsername("kimyk96").build();
//        return ResponseEntity.ok().body(memRepo.save(dto));
//    }
}
