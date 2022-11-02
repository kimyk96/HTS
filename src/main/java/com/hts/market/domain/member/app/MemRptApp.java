package com.hts.market.domain.member.app;

import com.hts.market.domain.member.dto.MemRptDto;
import com.hts.market.domain.member.repo.MemRepo;
import com.hts.market.domain.member.repo.MemRptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemRptApp {
    @Autowired MemRptRepo memRptRepo;
    @Autowired MemRepo memRepo;
    
    // 회원 신고
    public Integer save(MemRptDto.Create dto, String username) {
        dto.setRptMemNo(memRepo.findIdByMemUsername(username));
        return memRptRepo.save(dto);
    }

    // 신고 정리 1시간마다 실행
    @Scheduled(cron = "0 0 0/1 * * *")
    public void checkTable(){
        // 신고누적 5회시 회원 정지
        memRptRepo.findByCount().stream().forEach(target->{
            memRepo.updateMemIsEnabled(target);
        });
        // 일주일 경과한 신고 초기화
        memRptRepo.sortTable();
    }
}
