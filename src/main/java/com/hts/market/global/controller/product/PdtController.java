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
    @GetMapping("")
    public String product(){
        return "product/product";
    }

    @GetMapping("search")
    public String search(){
        return "product/product_search";
    }

    @GetMapping("{pdtNo}")
    public ModelAndView detail(@PathVariable Long pdtNo){
        return new ModelAndView("product/product_detail").addObject("pdtNo", pdtNo) ;
    }

    @GetMapping("upload")
    public String upload(){
        return "product/product_upload";
    }

    @GetMapping("edit")
    public String edit(){
        return "product/product_edit";
    }
    @GetMapping("cate")
    public String cate(){
        return "product/product_cate";
    }

}
