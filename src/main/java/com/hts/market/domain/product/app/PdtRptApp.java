package com.hts.market.domain.product.app;

import com.hts.market.domain.product.dto.PdtRtpDto;
import com.hts.market.domain.product.repo.PdtRptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PdtRptApp {
    @Autowired
    private PdtRptRepo pdtRptRepo;

    // 신고등록
    public Integer save(PdtRtpDto.Create dto){
        return null;
    }
    // 신고삭제
    public Integer delete(PdtRtpDto.Delete dto){
        return null;
    }
    // 신고목록
    public Integer findByRptNo(PdtRtpDto.Read dto){
        return null;
    }
    // 신고보기
    public  Integer findAll(PdtRtpDto.Page dto){
        return null;
    }
}
