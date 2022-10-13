package com.hts.market.global.controller.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PdtController {
    @GetMapping("/product")
    public String product(){
        return "product/product";
    }
}
