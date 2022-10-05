package com.hts.market.domain.member.repo;

import com.hts.market.domain.member.dto.MemRoleDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemRoleRepo {


    // 이하 설계도에 있는 메소드들
    
    // 회원 권한 추가
    Integer save(MemRoleDto.Create dto);

    // 회원 권한 조회
    List<MemRoleDto.Read> findAllById(Long memNo);

    // 회원 권한 삭제
    Integer delete(MemRoleDto.Delete dto);
    // 회원 권한 전체 삭제
    Integer deleteAll(Long memNo);
}
