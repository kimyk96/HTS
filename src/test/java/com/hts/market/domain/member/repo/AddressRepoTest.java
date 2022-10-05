package com.hts.market.domain.member.repo;

import com.hts.market.domain.member.dto.AddressDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressRepoTest {
    // 주소 저장
    Integer save(AddressDto.Create dto);

    // 주소 조회
    AddressDto.Read findById(Long addressNo);

    // 회원별 주소 전체 조회
    List<AddressDto.Read> findAllById(Long memNo);

    // 주소 수정
    Integer update(AddressDto.Update dto);

    // 주소 삭제
    Integer delete(AddressDto.Delete dto);
}
