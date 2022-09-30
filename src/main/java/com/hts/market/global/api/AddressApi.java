package com.hts.market.global.api;

import com.hts.market.domain.member.app.MemRoleApp;
import com.hts.market.domain.member.dto.MemRoleDto;
import com.hts.market.global.app.AddressApp;
import com.hts.market.global.dto.AddressDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api/v1/address")
public class AddressApi {

    @Autowired AddressApp addressApp;

    // 이하 설계도에 있는 메소드

    // 주소 생성
    @PostMapping("save")
    public ResponseEntity<Integer> save(AddressDto.Create dto){
        return ResponseEntity.ok().body(addressApp.save(dto));
    }
    
    // 주소 조회
    @GetMapping("find-by-id")
    public ResponseEntity<AddressDto.Read> findById(Long addressNo){
        return ResponseEntity.ok().body(addressApp.findById(addressNo));
    }

    // 주소 수정
    @PutMapping("update")
    public ResponseEntity<Integer> update(AddressDto.Update dto){
        return ResponseEntity.ok().body(addressApp.update(dto));
    }

    // 주소 삭제
    @DeleteMapping("delete")
    public ResponseEntity<Integer> delete(AddressDto.Delete dto){
        return ResponseEntity.ok().body(addressApp.delete(dto));
    }

}
