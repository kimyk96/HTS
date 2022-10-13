package com.hts.market.global.config.security.auth;

import com.hts.market.domain.member.dto.AddressDto;
import com.hts.market.domain.member.entity.MemEntity;
import com.hts.market.domain.member.repo.AddressRepo;
import com.hts.market.domain.member.repo.MemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired MemRepo memRepo;
    @Autowired AddressRepo addressRepo;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        // 회원 정보 확인 
        MemEntity memEntity = memRepo.loadUserByUsername(authentication.getName());
        List<AddressDto.Read> addressList = addressRepo.findAllById(memEntity.getMemNo());

        // 리다이렉션
        if(memEntity.getMemEmail() == null){
            // 미기입 정보 있을 시 -> 정보 기입 페이지
            response.sendRedirect("/signup");
        }else if(addressList.isEmpty()){
            // 주소 없을 시 -> 주소 등록 창으로 이동
            response.sendRedirect("/member/address");
        }else{
            // 메인 페이지
            response.sendRedirect("/product");
        }
    }
}