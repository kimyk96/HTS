package com.hts.market.domain.product.app;

import com.hts.market.domain.product.dto.PdtImgDto;
import com.hts.market.domain.product.repo.PdtImgRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public class PdtImgApp {
    @Autowired
    private PdtImgRepo pdtImgRepo;

    // 이미지 저장
    public Image save(PdtImgDto.Create dto){
        return null;
    }
    // 이미지 수정
    public Integer update(PdtImgDto.Update dto){
        return null;
    }
    // 이미지 보기
    public Integer findByImgNo(PdtImgDto.Read dto){
        return null;
    }
    // 이미지 삭제
    public Integer delete(PdtImgDto.Delete dto){
        return null;
    }
}
