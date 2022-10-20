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
    @GetMapping("")
    public String product(){
        return "board/board";
    }
    @GetMapping("search")
    public String search(){
        return "board/board_search";
    }
    @GetMapping("{brdNo}")
    public ModelAndView detail(@PathVariable Long brdNo){
        return new ModelAndView("board/board_detail").addObject("brdNo", brdNo) ;
    }
    @GetMapping("upload")
    public String upload(){
        return "board/board_upload";
    }
    @GetMapping("edit")
    public String edit(){
        return "board/board_edit";
    }
    @GetMapping("cate")
    public String cate(){
        return "board/board_cate";
    }
}
