package com.hts.market.global.controller.product;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("product")
@Secured("ROLE_USER")
public class PdtController {
    @GetMapping("")
    public String product(){
        return "product/product";
    }
}
