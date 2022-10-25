package com.hts.market.domain.member.repo;

import com.hts.market.domain.member.dto.MemDto;
import com.hts.market.domain.member.dto.MemImgDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemImgRepo {
    // 회원 이미지 추가
    Integer save(MemImgDto.Create dto);

    // 회원 이미지 삭제
    Integer delete(Long memNo);

    // 회원 이미지 수정
    Integer update(MemDto.Member dto);
}
