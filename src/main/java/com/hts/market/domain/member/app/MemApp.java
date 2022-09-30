package com.hts.market.domain.member.app;

import com.hts.market.domain.member.dto.MemDto;
import com.hts.market.domain.member.entity.MemEntity;
import com.hts.market.domain.member.repo.MemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemApp {
    @Autowired MemRepo memRepo;

    // 이하 새로 추가된 메소드

    // 인증된 전화번호 추가
    public Integer updateMemPhoneById(MemDto.UpdatePhone dto) {
        return memRepo.updateMemPhoneById(dto);
    }

    // 임시 회원가입
    public Integer saveTemp(MemDto.CreateTemp dto) {
        return memRepo.saveTemp(dto);
    }





    // 이하 설계도에 있는 메소드

    // 회원가입
    public Integer save(MemDto.Create dto) {
        return memRepo.save(dto);
    }

    // 회원 조회(memNo)
    public MemDto.Read findById(Long memNo) {
        return memRepo.findById(memNo);
    }

    // 회원 조회(memUsername)
    public MemDto.Read findByMemUsername(String memUsername) {
        return memRepo.findByMemUsername(memUsername);
    }

    // 회원 수정
    public Integer update(MemDto.Update dto) {
        return memRepo.update(dto);
    }

    // 회원 삭제
    public Integer delete(Long memNo) {
        return memRepo.delete(memNo);
    }

    // 회원명 중복검사
    public Integer countByMemUsername(String memUsername) {
        return memRepo.countByMemUsername(memUsername);
    }

    // 이메일 중복검사
    public Integer countByMemEmail(String memEmail) {
        return memRepo.countByMemEmail(memEmail);
    }

    // 닉네임 중복검사
    public Integer countByMemNickname(String memNickname) {
        return memRepo.countByMemNickname(memNickname);
    }

    // 전화번호 중복검사
    public Integer countByMemPhone(Integer memPhone) {
        return memRepo.countByMemPhone(memPhone);
    }

    // 비밀번호 업데이트
    public Integer updateMemPassword(String memPassword) {
        return memRepo.updateMemPassword(memPassword);
    }

    // 당도 검색
    public Integer findMemBrixById(Long memNo) {
        return memRepo.findMemBrixByMemNo(memNo);
    }

    // 로그인
    public Integer findByMemUsernameAndMemPassword(MemDto.Login dto) {
        return memRepo.findByMemUsernameAndMemPassword(dto);
    }
}
