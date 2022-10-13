package com.hts.market.domain.member.app;

import com.hts.market.domain.member.dto.MemImgDto;
import com.hts.market.domain.member.repo.MemImgRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.multipart.Part;
import org.springframework.stereotype.Service;

@Service
public class MemImgApp {
    @Autowired MemImgRepo memImgRepo;
    
    // 회원 이미지 추가
    public Integer save(MemImgDto.Create dto) {
        return memImgRepo.save(dto);
    }

    // 회원 이미지 삭제
    public Integer delete(MemImgDto.Delete dto) {
        return memImgRepo.delete(dto);
    }
}
