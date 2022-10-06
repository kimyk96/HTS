package com.hts.market.domain.product.app;

import com.hts.market.domain.product.dto.PdtRptDto;
import com.hts.market.domain.product.repo.PdtRptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PdtRptApp {
    @Autowired
    private PdtRptRepo pdtRptRepo;

    // 신고등록
    public Integer save(PdtRptDto.Create dto){
        return null;
    }
    // 신고삭제
    public Integer delete(PdtRptDto.Delete dto){
        return null;
    }
    // 신고목록
    public Integer findByRptNo(PdtRptDto.Read dto){
        return null;
    }
    // 신고보기
    public  Integer findAll(PdtRptDto.Read dto){
        return null;
    }
}
