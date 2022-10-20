package com.hts.market.domain.board.api;


import com.hts.market.domain.board.app.BrdLikeApp;
import com.hts.market.domain.board.dto.BrdLikeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.security.Principal;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/v1/brd-like")
public class BrdLikeApi {
    @Autowired
    private BrdLikeApp brdLikeApp;


    // 게시물 좋아요
    @PostMapping("save")
    public ResponseEntity<Integer> save(@Valid BrdLikeDto.Create dto, Principal principal){

        return ResponseEntity.ok().body(brdLikeApp.save(dto, principal.getName()));
    }

    // 게시물 좋아요 삭제
    @DeleteMapping("delete")
    public ResponseEntity<Integer> delete(@Valid BrdLikeDto.Delete dto, Principal principal){
        return ResponseEntity.ok().body(brdLikeApp.delete(dto, principal.getName()));
    }

    // 좋아요를 적용할 게시물의 번호
//    @GetMapping("find-brd-no-by-mem-no")
//    public ResponseEntity<List<BrdLikeDto.ReadList>> findBrdNoByMemNo(Principal principal){
//        return ResponseEntity.ok().body(brdLikeApp.findBrdNoByMemNo(principal.getName()));
//    }
//
//    // 좋아요를 적용하는 회원의 번호
//    @GetMapping("find-brd-like-by-mem-no")
//    public ResponseEntity<Integer> findMemNoByBrdNo(Long brdNo){
//        return null;
//    }
}
