package com.hts.market.domain.product.app;


import com.hts.market.domain.member.repo.MemRepo;
import com.hts.market.domain.product.dto.PdtRptDto;
import com.hts.market.domain.product.exception.ReportSaveFailException;
import com.hts.market.domain.product.repo.PdtRptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PdtRptApp {
    @Autowired
    private PdtRptRepo pdtRptRepo;
    @Autowired
    private MemRepo memRepo;
    //@Scheduled(cron = "* * * * * *")
    // 신고등록
    public Integer save(PdtRptDto.Create dto, String userName){
        Long memNo = pdtRptRepo.findIdByRptPdtNo(dto.getRptPdtNo());
        Long writerNo = memRepo.findIdByMemUsername(userName);
        if (memNo==writerNo){
            throw new ReportSaveFailException();
        }
        return pdtRptRepo.save(dto);
    }

    // 신고목록
    public List<PdtRptDto.Read> findAllByDto(PdtRptDto.Read dto){
        return pdtRptRepo.findAllByDto(dto);
    }

    // 신고번호로 신고삭제
    public Integer deleteByRptNo(PdtRptDto.Delete dto){
        return pdtRptRepo.deleteByRptNo(dto);
    }

    // 회원번호로 신고삭제
    public Integer deleteByRptMemNo(PdtRptDto.Delete dto){
        return pdtRptRepo.deleteByRptMemNo(dto);
    }

    // 상품번호로 신고삭제
    public Integer deleteByRptPdtNo(Long pdtNo){
        return pdtRptRepo.deleteByRptPdtNo(pdtNo);
    }
}
