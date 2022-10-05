package com.hts.market.domain.member.repo;

import com.hts.market.domain.member.dto.MemDto;
import com.hts.market.domain.member.entity.MemEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MemRepo {
    
    // 새로 추가된 메소드
    
    // 임시 회원가입
    Integer saveTemp(MemDto.CreateTemp dto);

    // 회원 조회(memUsername)
    MemEntity loadUserByUsername(String memUsername);


    // 이하 설계도에 있는 메소드

    // 회원가입
    Integer save(MemDto.Create dto);

    // 회원 조회(memNo)
    MemDto.Read findById(Long memNo);

    // 회원 조회(memUsername)
    MemDto.Read findByMemUsername(String memUsername);

    // 회원 수정
    Integer update(MemDto.Update dto);

    // 회원 삭제
    Integer delete(Long memNo);

    // 회원명 중복검사
    Integer countByMemUsername(String memUsername);

    // 이메일 중복검사
    Integer countByMemEmail(String memEmail);

    // 닉네임 중복검사
    Integer countByMemNickname(String memNickname);

    // 전화번호 중복검사
    Integer countByMemPhone(Integer memPhone);

    // 비밀번호 업데이트
    Integer updateMemPassword(MemDto.Update dto);

    // 당도 검색
    Integer findMemBrixByMemNo(Long memNo);

    // 인증된 전화번호 추가
    Integer updateMemPhoneById(MemDto.UpdatePhone dto);

}