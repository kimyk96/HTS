package com.hts.market.domain.member.repo;

import com.hts.market.domain.member.dto.MemImgDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.http.codec.multipart.Part;

@Mapper
public interface MemImgRepo {
    // 이하 설계도에 있는 메소드들
    // 회원 이미지 추가
    Integer save(MemImgDto.Create dto);

    // 회원 이미지 조회
    MemImgDto.Read findById(MemImgDto.Read dto);

    // 회원 이미지 수정
    Integer update(MemImgDto.Update dto);

    // 회원 이미지 삭제
    Integer delete(MemImgDto.Delete dto);
}
