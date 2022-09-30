package com.hts.market.global.app;

import com.hts.market.global.dto.AddressDto;
import com.hts.market.global.repo.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressApp {

    @Autowired AddressRepo addressRepo;
    
    // 주소 생성
    public Integer save(AddressDto.Create dto) {
        return addressRepo.save(dto);
    }

    // 주소 조회
    public AddressDto.Read findById(Long addressNo) {
        return addressRepo.findById(addressNo);
    }

    // 주소 수정
    public Integer update(AddressDto.Update dto) {
        return addressRepo.update(dto);
    }

    // 주소 삭제
    public Integer delete(AddressDto.Delete dto) {
        return addressRepo.delete(dto);
    }
}
