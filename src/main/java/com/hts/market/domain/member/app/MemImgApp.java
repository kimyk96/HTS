package com.hts.market.domain.member.app;

import com.hts.market.domain.member.dto.MemImgDto;
import com.hts.market.domain.member.repo.MemImgRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.multipart.Part;
import org.springframework.stereotype.Service;

@Service
public class MemImgApp {

    @Autowired MemImgRepo memImgRepo;

    // 이하 설계도에 있는 메소드들
    
    // 회원 이미지 추가
    public Integer save(Part memImg) {
        return memImgRepo.save(memImg);
    }
    
    // 회원 이미지 삭제
    public Integer delete(Long memNo) {
        return memImgRepo.delete(memNo);
    }

    // 회원 이미지 수정
    public Integer update(MemImgDto dto) {
        return memImgRepo.update(dto);
    }
    
    // 회원 이미지 조회
    public String findById(Long memeNo){
        return memImgRepo.findById(memeNo);
    }
}
