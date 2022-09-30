package com.hts.market.global.repo;

import com.hts.market.global.dto.AddressDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressRepo {

    Integer save(AddressDto.Create dto);

    AddressDto.Read findById(Long addressNo);

    Integer update(AddressDto.Update dto);

    Integer delete(AddressDto.Delete dto);
}
