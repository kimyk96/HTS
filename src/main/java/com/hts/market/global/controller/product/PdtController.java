package com.hts.market.global.controller.product;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("product")
@Secured("ROLE_USER")
public class PdtController {
    // 상품 목록
    @GetMapping("")
    public String product() {
        return "product/product";
    }

    // 상품 검색
    @GetMapping("search")
    public String search() {
        return "product/product_search";
    }

    // 상품 상세
    @GetMapping("{pdtNo}")
    public ModelAndView detail(@PathVariable Long pdtNo) {
        return new ModelAndView("product/product_detail").addObject("pdtNo", pdtNo);
    }

    // 상품 등록
    @GetMapping("upload")
    public String upload() {
        return "product/product_upload";
    }

    // 상품 수정
    @GetMapping("edit")
    public String edit() {
        return "product/product_edit";
    }

    // 상품 카테고리
    @GetMapping("cate")
    public String cate() {
        return "product/product_cate";
    }
}
