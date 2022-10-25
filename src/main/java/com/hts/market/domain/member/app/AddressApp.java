package com.hts.market.domain.member.app;

import com.hts.market.domain.member.dto.AddressDto;
import com.hts.market.domain.member.repo.AddressRepo;
import com.hts.market.domain.member.repo.MemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressApp {
    @Autowired AddressRepo addressRepo;
    @Autowired MemRepo memRepo;

    // 주소 조회
    public List<AddressDto.Read> findAllByName(String memUsername) {
        return addressRepo.findAllByName(memRepo.findIdByMemUsername(memUsername));
    }

    // 주소 생성
    public Integer save(AddressDto.Create dto, String memUsername) {
        dto.setMemNo(memRepo.findIdByMemUsername(memUsername));
        return addressRepo.save(dto);
    }

    // 주소 삭제
    public Integer delete(AddressDto.Delete dto) {
        return addressRepo.delete(dto);
    }
}
