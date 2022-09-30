package com.hts.market.domain.product.app;

import com.hts.market.domain.product.dto.PdtCateDto;
import com.hts.market.domain.product.repo.PdtCateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PdtCateApp {
    @Autowired
    private PdtCateRepo pdtCateRepo;

    // 카테고리 목록
    public Integer findAll(PdtCateDto.Read dto){
        return null;
    }
}
