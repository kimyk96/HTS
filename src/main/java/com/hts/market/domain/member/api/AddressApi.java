package com.hts.market.domain.member.api;

import com.hts.market.domain.member.app.AddressApp;
import com.hts.market.domain.member.dto.AddressDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/v1/address")
public class AddressApi {
    @Autowired AddressApp addressApp;

    // 주소 생성
    @PostMapping("")
    public ResponseEntity<Integer> save(AddressDto.Create dto, Principal principal){
        return ResponseEntity.ok().body(addressApp.save(dto, principal.getName()));
    }
    // 주소 삭제
    @DeleteMapping("")
    public ResponseEntity<Integer> delete(AddressDto.Delete dto){
        return ResponseEntity.ok().body(addressApp.delete(dto));
    }
}
