package com.hts.market.domain.product.app;

import com.hts.market.domain.product.dto.PdtCateDto;
import com.hts.market.domain.product.repo.PdtCateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PdtCateApp {
    @Autowired private PdtCateRepo pdtCateRepo;
//
//    // 카테고리 생성
//    public Integer save(PdtCateDto.Create dto){
//        return pdtCateRepo.save(dto);
//    }
    // 카테고리 목록
    public List<PdtCateDto.Read> findAll() {
        return pdtCateRepo.findAll();
    }
}
