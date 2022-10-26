package com.hts.market.domain.member.repo;

import com.hts.market.domain.member.dto.MemDto;
import com.hts.market.domain.member.entity.MemEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemRepo {
    // 회원명 중복검사
    Boolean countByMemUsername(String memUsername);

    // 회원 중복검사
    Boolean countByMemNo(Long memNo);

    // 회원가입
    Integer save(MemDto.Create dto);

    // 비밀번호 업데이트
    Integer updateMemPassword(MemDto.Update dto);

    // 회원 조회(memUsername)
    MemEntity loadUserByUsername(String memUsername);

    // 회원 조회(memNo)
    MemEntity loadUserByMemNo(Long memNo);

    // 회원아이디 업데이트
    Integer updateMemUsernameById(String memUsername, Long memNo);

    // 회원 정보 수정
    Integer updateByMemUsername(MemDto.Update dto);

    // 회원 정보 전체 조회(이미지, 주소)
    Optional<MemDto.Member> findById(Long memNo);

    // 회원 정보 전체 조회(이미지, 주소)
    Optional<MemDto.Member> findByName(String memUsername);

    // 회원명으로 회원번호 조회
    Long findIdByMemUsername(String memUsername);
    // 회원번호로 회원명 조회
    String findMemUsernameById(Long memNo);

    // 닉네임 변경
    Integer updateMemNickname(MemDto.Member dto);

    Boolean countByMemNickname(String memUsername, String memNickname);

    // 회원 탈퇴
    Integer delete(Long memNo);
}