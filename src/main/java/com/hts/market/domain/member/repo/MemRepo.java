package com.hts.market.domain.member.repo;

import com.hts.market.domain.member.dto.MemDto;
import com.hts.market.domain.member.entity.MemEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MemRepo {
    // 임시 회원가입
    public Integer saveTemp(MemDto.CreateTemp dto);

    // 회원가입
    public Integer save(MemDto.Create dto);

    // 회원 조회(memNo)
    public MemDto.Read findById(Long memNo);

    // 회원 조회(memUsername)
    public MemEntity findByMemUsername(String memUsername);

    // 회원 수정
    public Integer update(MemDto.Update dto);

    // 회원 삭제
    public Integer delete(Long memNo);

    // 회원명 중복검사
    public Integer countByMemUsername(String memUsername);

    // 이메일 중복검사
    public Integer countByMemEmail(String memEmail);

    // 닉네임 중복검사
    public Integer countByMemNickname(String memNickname);

    // 전화번호 중복검사
    public Integer countByMemPhone(Integer memPhone);

    // 비밀번호 업데이트
    public Integer updateMemPassword(String memPassword);

    // 당도 검색
    public Integer findMemBrixByMemNo(Long memNo);

    // 인증된 전화번호 추가
    public Integer updateMemPhoneById(MemDto.UpdatePhone dto);
}