package com.hts.market.domain.member.repo;

import com.hts.market.domain.member.dto.MemImgDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.http.codec.multipart.Part;

@Mapper
public interface MemImgRepo {

    // 이하 설계도에 있는 메소드들 
    
    // 회원 이미지 추가
    Integer save(Part memImg);

    // 회원 이미지 삭제
    Integer delete(Long memNo);

    // 회원 이미지 수정
    Integer update(MemImgDto dto);

    // 회원 이미지 조회
    String findById(Long memeNo);
}
