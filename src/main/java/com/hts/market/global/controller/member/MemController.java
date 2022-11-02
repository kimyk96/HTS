package com.hts.market.global.controller.member;

import com.hts.market.domain.member.repo.MemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping("member")
@Secured("ROLE_USER")
public class MemController {
    @Autowired MemRepo memRepo;

    // 회원 정보
    @GetMapping("")
    public String member() {
        return "member/member";
    }

    // 타 회원 정보
    @GetMapping("{memNo}")
    public ModelAndView profile(@PathVariable Long memNo, Principal principal) {
        if (memNo.equals(memRepo.findIdByMemUsername(principal.getName()))) {
            return new ModelAndView("member/member");
        } else {
            return new ModelAndView("member/member_other").addObject("memNo", memNo);
        }
    }

    // 주소 지정
    @GetMapping("address")
    public String address() {
        return "member/member_address";
    }

    // 저장된 주소 목록
    @GetMapping("address-list")
    public String addressList() {
        return "member/member_address_list";
    }

    // 프로필 수정
    @GetMapping("profile")
    public String profile() {
        return "member/member_profile";
    }

    // 관심 상품
    @GetMapping("favorite")
    public String favorite() {
        return "member/member_favorite";
    }

    // 판매중인 상품
    @GetMapping("product")
    public String product() {
        return "member/member_product";
    }

    // 작성한 게시글
    @GetMapping("board")
    public String board() {
        return "member/member_board";
    }

    // 회원 신고
    @GetMapping("report")
    public String report() {
        return "member/member_report";
    }
}
