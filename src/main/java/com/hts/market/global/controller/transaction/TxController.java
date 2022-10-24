package com.hts.market.global.controller.transaction;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("transaction")
@Secured("ROLE_USER")
public class TxController {
    @GetMapping("")
    public String transaction(){
        return "transaction/transaction";
    }
    @GetMapping("purchase")
    public String purchase(){
        return "transaction/purchase_list";
    }
    @GetMapping("sell")
    public String sell(){
        return "transaction/sell_list";
    }
    @GetMapping("review")
    public String review(){
        return "transaction/review";
    }
    @GetMapping("review/upload")
    public String upload(){
        return "transaction/review_upload";
    }

}
