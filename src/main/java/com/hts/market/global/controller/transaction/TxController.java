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
    // 거래 목록
    @GetMapping("")
    public String transaction() {
        return "transaction/transaction";
    }

    // 구매 내역
    @GetMapping("purchase")
    public String purchase() {
        return "transaction/purchase_list";
    }

    // 판매 내역
    @GetMapping("sell")
    public String sell() {
        return "transaction/sell_list";
    }

    // 타인 구매 내역
    @GetMapping("purchase/{memNo}")
    public ModelAndView otherPurchase(@PathVariable Long memNo) {
        return new ModelAndView("transaction/purchase_list").addObject("memNo", memNo);
    }

    // 타인 판매 내역
    @GetMapping("sell/{memNo}")
    public ModelAndView otherSell(@PathVariable Long memNo) {
        return new ModelAndView("transaction/sell_list").addObject("memNo", memNo);
    }

    // 거래 리뷰
    @GetMapping("review")
    public String review() {
        return "transaction/review";
    }

    // 거래 리뷰 등록
    @GetMapping("review/upload")
    public String upload() {
        return "transaction/review_upload";
    }

}
