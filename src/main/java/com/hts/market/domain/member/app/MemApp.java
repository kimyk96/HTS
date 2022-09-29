package com.hts.market.domain.member.app;

import com.hts.market.domain.member.repo.MemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemApp {
    @Autowired MemRepo memRepo;
    public Integer countByMemPhone(Integer memPhone) {
        return memRepo.countByMemPhone(memPhone);
    }
}
