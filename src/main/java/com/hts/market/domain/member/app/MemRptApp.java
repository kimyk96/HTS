package com.hts.market.domain.member.app;

import com.hts.market.domain.member.dto.MemRptDto;
import com.hts.market.domain.member.repo.MemRptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemRptApp {

    @Autowired MemRptRepo memRptRepo;
    
    // 회원 신고
    public Integer save(MemRptDto.Create dto) {
        return memRptRepo.save(dto);
    }
}
