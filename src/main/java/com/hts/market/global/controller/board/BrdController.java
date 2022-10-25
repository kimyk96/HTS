package com.hts.market.global.controller.board;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("board")
@Secured("ROLE_USER")
public class BrdController {
    // 글 목록
    @GetMapping("")
    public String product() {
        return "board/board";
    }

    // 글 검색
    @GetMapping("search")
    public String search() {
        return "board/board_search";
    }

    // 글 상세
    @GetMapping("{brdNo}")
    public ModelAndView detail(@PathVariable Long brdNo) {
        return new ModelAndView("board/board_detail").addObject("brdNo", brdNo);
    }

    // 글 저장
    @GetMapping("upload")
    public String upload() {
        return "board/board_upload";
    }

    // 글 수정
    @GetMapping("edit")
    public String edit() {
        return "board/board_edit";
    }

    // 글 카테고리
    @GetMapping("cate")
    public String cate() {
        return "board/board_cate";
    }
}
