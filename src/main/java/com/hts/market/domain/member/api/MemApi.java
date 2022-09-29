package com.hts.market.domain.member.api;

import com.hts.market.domain.member.app.MemApp;
import com.hts.market.domain.member.dto.MemDto;
import com.hts.market.domain.member.repo.MemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v1/mem")
public class MemApi {
    @Autowired MemApp memApp;
    @GetMapping("count-by-mem-phone")
    public ResponseEntity<Integer> countByMemPhone(Integer memPhone) {
        return ResponseEntity.ok().body(memApp.countByMemPhone(memPhone));
    }















    @PostMapping("/save")
    public ResponseEntity<Integer> save(MemDto.Create dto){

        return null;
    }

    @Autowired MemRepo memRepo;
    @Secured("ROLE_USER")
    @GetMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> saveTest(){
        MemDto.Create dto = MemDto.Create.builder().memName("김용광").memEmail("kimyk96@gmail.com").memNickname("용팡").memPassword("12341234").memPhone(1027249409).memUsername("kimyk96").build();
        return ResponseEntity.ok().body(memRepo.save(dto));
    }
}
