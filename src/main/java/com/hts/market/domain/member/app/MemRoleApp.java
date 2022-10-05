package com.hts.market.domain.member.app;

import com.hts.market.domain.member.dto.MemRoleDto;
import com.hts.market.domain.member.repo.MemRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemRoleApp {

    @Autowired MemRoleRepo memRoleRepo;

    // 이하 설계도에 있는 메소드들 
    
    // 회원 권한 출가
    public Integer save(MemRoleDto.Create dto) {
        return memRoleRepo.save(dto);
    }

    // 회원 권한 조회
    public List<MemRoleDto.Read> findAllById(Long memNo) {
        return memRoleRepo.findAllById(memNo);
    }

    // 회원 권한 삭제
    public Integer delete(MemRoleDto.Delete dto) {
        return memRoleRepo.delete(dto);
    }

    // 회원 권한 전체 삭제
    public Integer deleteAll(Long memNo) {
        return memRoleRepo.deleteAll(memNo);
    }

}
