package com.hts.market.domain.member.repo;

import com.hts.market.domain.member.dto.AddressDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressRepo {
    // 주소 저장
    Integer save(AddressDto.Create dto);
    // 주소 삭제
    Integer delete(AddressDto.Delete dto);
}
