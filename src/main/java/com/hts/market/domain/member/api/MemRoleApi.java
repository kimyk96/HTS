package com.hts.market.domain.member.api;

import com.hts.market.domain.member.app.MemRoleApp;
import com.hts.market.domain.member.dto.MemRoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api/v1/mem-role")
public class MemRoleApi {

//    @Autowired MemRoleApp memRoleApp;
//
//    // 이하 설계도에 있는 메소드
//
//    // 회원 권한 추가
//    @PostMapping("save")
//    public ResponseEntity<Integer> save(MemRoleDto.Create dto){
//        return ResponseEntity.ok().body(memRoleApp.save(dto));
//    }
//
//    // 회원 권한 조회
//    @GetMapping("find-all-by-id")
//    public ResponseEntity<List<MemRoleDto.Read>> findAllById(Long memNo){
//        return ResponseEntity.ok().body(memRoleApp.findAllById(memNo));
//    }
//
//    // 회원 권한 삭제
//    @DeleteMapping("delete")
//    public ResponseEntity<Integer> delete(MemRoleDto.Delete dto){
//        return ResponseEntity.ok().body(memRoleApp.delete(dto));
//    }


}
