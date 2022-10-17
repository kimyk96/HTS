package com.hts.market.domain.board.api;

import com.hts.market.domain.board.app.BrdApp;
import com.hts.market.domain.board.dto.BrdDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.security.Principal;
import java.time.LocalDateTime;

@RestController
@Validated
@RequestMapping("/api/v1/brd")
@Secured("ROLE_USER")
public class BrdApi {
    @Autowired BrdApp brdApp;

    // 게시물 작성
    @PostMapping("save")
    public ResponseEntity<Integer> save(@Valid BrdDto.Create dto, Principal principal){
        return ResponseEntity.ok().body(brdApp.save(dto,principal.getName()));
    }

    // 게시물 수정
    @PutMapping("update")
    public ResponseEntity<Integer> update(@Valid BrdDto.Update dto, Principal principal){

        return ResponseEntity.ok().body(brdApp.update(dto));
    }

    //게시물 삭제
    @DeleteMapping("delete")
    public ResponseEntity<Integer> delete(@Valid BrdDto.Delete dto, Principal principal, BindingResult bindingResult){

        return ResponseEntity.ok().body(brdApp.delete(dto));
    }

    //게시물읽기
    @GetMapping("find-by-brd-no")
    public ResponseEntity<BrdDto.Detail> findByBrdNo(@NotNull Long brdNo, Principal principal){
//        BrdDto.Detail result= brdApp.findByBrdNo(brdNo,)
        return null;
    }

    //조회수 증가
    @GetMapping("find-views-by-brd-no")
    public ResponseEntity<Long> findViewsByBrdNo(Long brdNo){
        return null;
    }

    //게시물 찾기
    @GetMapping("search-by-keyword")
    public ResponseEntity<LocalDateTime> findCreatedAtByBrdNo(Long brdNo){
        return null;
    }

    //카테고리 등록
    @GetMapping("find-cate-no-by-brd-no")
    public ResponseEntity<Long> findCateNoByBrdNo(Long brdNo){
        return null;
    }
}
