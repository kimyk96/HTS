package com.hts.market.domain.member.app;

import com.hts.market.domain.member.dto.MemDto;
import com.hts.market.domain.member.dto.MemRoleDto;
import com.hts.market.domain.member.entity.MemEntity;
import com.hts.market.domain.member.exception.MemberAlreadyExsistException;
import com.hts.market.domain.member.exception.MemberNotFoundException;
import com.hts.market.domain.member.repo.MemRepo;
import com.hts.market.domain.member.repo.MemRoleRepo;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemApp {
    @Autowired MemRepo memRepo;
    @Autowired MemRoleRepo memRoleRepo;
    @Autowired PasswordEncoder passwordEncoder;

    // 인증 코드
    public Integer code(String memUsername, String code, Long memNo) {
        // 회원번호 확인
        if (memNo == null) {
            // 이미 가입된 회원 확인
            Boolean usernameTaken = memRepo.countByMemUsername(memUsername);
            if (usernameTaken) {
                // 비밀번호 갱신
                MemDto.Update updateDto = MemDto.Update.builder()
                        .memUsername(memUsername).memPassword(passwordEncoder.encode(code)).build();
                return memRepo.updateMemPassword(updateDto);
            }
            // 가입되지 않은 회원 -> 가입
            MemDto.Create memCreateDto = MemDto.Create.builder()
                    .memUsername(memUsername)
                    .memPassword(passwordEncoder.encode(code))
                    .memNickname("")
                    .memEmail("").build();
            Integer memSaveResult = memRepo.save(memCreateDto);
            MemRoleDto.Create memRoleDtoCreate = MemRoleDto.Create.builder()
                    .memNo(memCreateDto.getMemNo()).roleNo(2L).build();
            Integer memRoleSaveResult = memRoleRepo.save(memRoleDtoCreate);
        } else {
            // memNo 있음
            return Integer.parseInt(code);
        }
        return 1;
    }

    public Integer updateMemUsernameById(String memUsername, Long memNo) {
        return memRepo.updateMemUsernameById(memUsername, memNo);
    }

    // 회원 정보 수정
    public Integer updateByMemUsername(MemDto.Update dto) {
        return memRepo.updateByMemUsername(dto);
    }

    // 회원번호로 정보 조회
    public MemDto.Member findById(Long memNo) {
        return memRepo.findById(memNo).orElseThrow(() -> new MemberNotFoundException());
    }

    // 회원명으로 정보 조회
    public MemDto.Member findByName(String memUsername) {
        return memRepo.findByName(memUsername).orElseThrow(() -> new MemberNotFoundException());
    }

}
