package com.hts.market.domain.board.api;

import com.hts.market.domain.board.app.*;
import com.hts.market.domain.board.dto.BrdDto;
import com.hts.market.domain.board.dto.BrdImgDto;
import com.hts.market.domain.board.dto.BrdLikeDto;
import com.hts.market.domain.member.app.MemApp;
import com.hts.market.domain.product.dto.PdtDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/v1/brd")
@Secured("ROLE_USER")
public class BrdApi {
    @Autowired
    private BrdApp brdApp;
    @Autowired
    private BrdImgApp brdImgApp;
    @Autowired
    private BrdLikeApp brdLikeApp;
    @Autowired
    private BrdRptApp brdRptApp;
    @Autowired
    private CmtApp cmtApp;
    @Autowired
    private MemApp memApp;

    // 게시물 작성
    @PostMapping("save")
    public ResponseEntity<Integer> save(@Valid BrdDto.Create dto, Principal principal) throws IOException {
        brdImgApp.save(BrdImgDto.FileList.builder().brdNo(dto.getBrdNo()).files(dto.getFiles()).build());
        brdApp.save(dto,principal.getName());
        return ResponseEntity.ok().body(1);
    }

    // 게시물 수정
    @PutMapping("update")
    public ResponseEntity<Integer> update(@Valid BrdDto.Update dto, Principal principal, BindingResult bindingResult){
        brdApp.update(dto, principal.getName());
        return ResponseEntity.ok().body(brdApp.update(dto,principal.getName()));
    }

    //게시물 삭제
    @DeleteMapping("delete")
    public ResponseEntity<Integer> delete(@Valid BrdDto.Delete dto, Principal principal, BindingResult bindingResult) throws IOException {
        brdImgApp.deleteAll(dto.getBrdNo());
        brdApp.delete(dto, principal.getName());
        brdLikeApp.delete(BrdLikeDto.Delete.builder().brdNo(dto.getBrdNo()).build(),principal.getName());
        cmtApp.deleteAll(dto.getBrdNo());
        return ResponseEntity.ok().body(1);

    }

    //게시물읽기
    @GetMapping("find-by-brd-no")
    public ResponseEntity<BrdDto.Detail> findByBrdNo(@NotNull Long brdNo, Principal principal){
        BrdDto.Detail result= brdApp.findByBrdNo(brdNo, principal.getName());
        return ResponseEntity.ok().body(result);
    }

    // 목록 조회
    @GetMapping("find-all-by-data")
    public ResponseEntity<List<BrdDto.ReadList>> findAllByData(@Valid  BrdDto.ListData dto, Principal principal, BindingResult bindingResult) {
        return ResponseEntity.ok().body(brdApp.findAllByData(dto, principal.getName()));
    }

    //게시물 찾기
//    @GetMapping("search-by-keyword")
//    public ResponseEntity<List<BrdDto.Read>> searchByKeyword(@Valid BrdDto.ListData dto, Principal principal){
//        return ResponseEntity.ok().body(brdApp.searchByKeyword(dto));
//    }

}
