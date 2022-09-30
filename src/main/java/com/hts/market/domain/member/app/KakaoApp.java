package com.hts.market.domain.member.app;

import com.hts.market.domain.member.dto.MemDto;
import com.hts.market.domain.member.dto.MemRoleDto;
import com.hts.market.domain.member.dto.RoleDto;
import com.hts.market.domain.member.exception.MemberAlreadyExsistException;
import com.hts.market.domain.member.repo.MemRepo;
import com.hts.market.domain.member.repo.MemRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Service
public class KakaoApp {
    @Autowired MemRepo memRepo;
    @Autowired MemRoleRepo memRoleRepo;
    @Autowired PasswordEncoder passwordEncoder;

    // 카카오 회원가입
    public Long save(String code) {
        Map memTokens = getTokens(code);
        Map memInfo = getMemInfo(code, memTokens.get("access_token").toString());
        Map memAccount = (Map) memInfo.get("kakao_account");
        Map memProfile = (Map) memAccount.get("profile");

        // 회원 가입 여부 확인
        if(memRepo.countByMemUsername(memInfo.get("id").toString()).equals(1)){
            // 이미 가입된 회원 -> 자동 로그인
            throw new MemberAlreadyExsistException();
        }else{
            // 회원 가입 진행
            MemDto.Create memDto = MemDto.Create.builder()
                    .memSignupType("kakao")
                    .memAccessToken(memTokens.get("access_token").toString())
                    .memRefreshToken(memTokens.get("refresh_token").toString())
                    .memUsername(memInfo.get("id").toString())
                    .memPassword(passwordEncoder.encode(memInfo.get("id").toString()))
                    .memNickname(memProfile.get("nickname").toString())
                    .memPhone(0)
                    .memName("0")
                    .memEmail(memAccount.get("email").toString())
                    .build();
            memRepo.save(memDto);

            // 권한 부여 (일반 유저)
            MemRoleDto.Create memRoleDto = MemRoleDto.Create.builder().roleNo(2L).memNo(memDto.getMemNo()).build();
            memRoleRepo.save(memRoleDto);
            return memDto.getMemNo();
        }
    }
    // accessToken
    public Map getTokens(String code) {
        // Request Body
        MultiValueMap<String,String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("grant_type",   "authorization_code");
        requestBody.add("client_id",    "1b484f0bd9bd6502362669834ce3920a");
        requestBody.add("redirect_uri", "http://localhost:8087/api/v1/kakao");
        requestBody.add("code",         code);

        // Post
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> response = restTemplate.postForEntity("https://kauth.kakao.com/oauth/token", requestBody, Map.class);
        return response.getBody();
    }

    // 사용자 정보 가져오기
    public Map getMemInfo(String code, String accessToken) {
        // Headers
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setBearerAuth(accessToken);

        // Request Body
        MultiValueMap<String,Object> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("secure_resource",  "false");

        // Build Request
        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(requestBody, requestHeaders);

        // Post
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> response = restTemplate.postForEntity("https://kapi.kakao.com/v2/user/me", request, Map.class);
        return response.getBody();
    }
}