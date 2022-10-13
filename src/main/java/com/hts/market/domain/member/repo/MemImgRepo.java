package com.hts.market.domain.member.repo;

import com.hts.market.domain.member.dto.MemImgDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.http.codec.multipart.Part;

@Mapper
public interface MemImgRepo {
    // 회원 이미지 추가
    Integer save(MemImgDto.Create dto);
    // 회원 이미지 삭제
    Integer delete(MemImgDto.Delete dto);
}
