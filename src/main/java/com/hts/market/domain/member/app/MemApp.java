package com.hts.market.domain.member.app;

import com.hts.market.domain.member.dto.MemDto;
import com.hts.market.domain.member.dto.MemRoleDto;
import com.hts.market.domain.member.entity.MemEntity;
import com.hts.market.domain.member.exception.MemberAlreadyExsistException;
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
        if(memNo==null){
            // 이미 가입된 회원 확인
            Boolean usernameTaken = memRepo.countByMemUsername(memUsername);
            if(usernameTaken){
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
        }else{
            // memNo 있음
            return Integer.parseInt(code);
        }
        return 1;
    }

    public Integer updateMemUsernameById(String memUsername, Long memNo){
        return memRepo.updateMemUsernameById(memUsername, memNo);
    }

    // 회원 정보 수정
    public Integer updateByMemUsername(MemDto.Update dto) {
        return memRepo.updateByMemUsername(dto);
    }


//
//    // 회원가입
//    public Integer save(MemDto.Create dto) throws CoolsmsException {
//        // 요청 전화번호
//        String memUsername = dto.getMemUsername();
//
//        // 이미 가입된 회원 확인
//        Boolean usernameTaken = memRepo.countByMemUsername(memUsername);
//        if(usernameTaken){
//            throw new MemberAlreadyExsistException();
//        }
//
//        // 인증 문자 발송
//        String code = smsApp.send(memUsername);
//        // 코드와 함께 회원 저장
//        dto.setMemPassword(passwordEncoder.encode(code));
//        return memRepo.save(dto);
//    }




//    // 회원 조회(memNo)
//    public MemDto.Read findById(Long memNo) {
//        return memRepo.findById(memNo);
//    }
//
//    // 회원 조회(memUsername)
////    public MemDto.Read findByMemUsername(String memUsername) {
////        return memRepo.findByMemUsername(memUsername);
////    }
//
//    // 회원 수정
//    public Integer update(MemDto.Update dto) {
//        return memRepo.update(dto);
//    }
//
//    // 회원 삭제
//    public Integer delete(Long memNo) {
//        return memRepo.delete(memNo);
//    }
//
//    // 회원명 중복검사
////    public Integer countByMemUsername(String memUsername) {
////        return memRepo.countByMemUsername(memUsername);
////    }
//
//    // 이메일 중복검사
//    public Integer countByMemEmail(String memEmail) {
//        return memRepo.countByMemEmail(memEmail);
//    }
//
//    // 닉네임 중복검사
//    public Integer countByMemNickname(String memNickname) {
//        return memRepo.countByMemNickname(memNickname);
//    }
//
//    // 전화번호 중복검사
//    public Integer countByMemPhone(Integer memPhone) {
//        return memRepo.countByMemPhone(memPhone);
//    }
//
//    // 비밀번호 업데이트
//    public Integer updateMemPassword(MemDto.Update dto) {
//        return memRepo.updateMemPassword(dto);
//    }
//
//    // 당도 검색
//    public Integer findMemBrixById(Long memNo) {
//        return memRepo.findMemBrixByMemNo(memNo);
//    }

}
