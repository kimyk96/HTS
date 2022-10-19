package com.hts.market.domain.member.app;

import com.hts.market.domain.member.dto.MemDto;
import com.hts.market.domain.member.dto.MemImgDto;
import com.hts.market.domain.member.dto.MemRoleDto;
import com.hts.market.domain.member.entity.MemEntity;
import com.hts.market.domain.member.exception.MemberAlreadyExsistException;
import com.hts.market.domain.member.exception.MemberImageSaveFailException;
import com.hts.market.domain.member.exception.MemberNotFoundException;
import com.hts.market.domain.member.exception.NicknameAlreadyTakenException;
import com.hts.market.domain.member.repo.MemImgRepo;
import com.hts.market.domain.member.repo.MemRepo;
import com.hts.market.domain.member.repo.MemRoleRepo;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

@Service
public class MemApp {
    @Autowired MemRepo memRepo;
    @Autowired MemRoleRepo memRoleRepo;
    @Autowired PasswordEncoder passwordEncoder;
    @Autowired MemImgRepo memImgRepo;

    @Value("${hts.imgUrl}") private String imgUrl;

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
            memRepo.save(memCreateDto);
            MemRoleDto.Create memRoleDtoCreate = MemRoleDto.Create.builder()
                    .memNo(memCreateDto.getMemNo()).roleNo(2L).build();
            memRoleRepo.save(memRoleDtoCreate);
            MemImgDto.Create memImgDtoCreate = MemImgDto.Create.builder()
                    .memNo(memCreateDto.getMemNo()).imgPath("member/default.png").build();
            memImgRepo.save(memImgDtoCreate);
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
        MemDto.Member member = memRepo.findById(memNo).orElseThrow(() -> new MemberNotFoundException());
        if(member.getImgPath()==null){
            member.setImgPath("/img/example/profile.png");
        }else{
            member.setImgPath(imgUrl + member.getImgPath());
        }
        return member;
    }

    // 회원명으로 정보 조회
    public MemDto.Member findByName(String memUsername) {
        MemDto.Member member = memRepo.findByName(memUsername).orElseThrow(() -> new MemberNotFoundException());
        if(member.getImgPath()==null){
            member.setImgPath("/img/example/profile.png");
        }else{
            member.setImgPath(imgUrl + member.getImgPath());
        }
        return member;
    }

    // 프로필 사진 & 닉네임 수정
    public Integer updateProfile(MemDto.Profile dto, String memUsername) {

        if(memRepo.countByMemNickname(memUsername, dto.getMemNickname())){
            throw new NicknameAlreadyTakenException();
        };

        // 정보 저장 dto 생성
        dto.setMemUsername(memUsername);
        dto.setMemNo(memRepo.findIdByMemUsername(memUsername));
        if(dto.getImage()==null){
            MemDto.Member member = MemDto.Member.builder()
                    .memNo(dto.getMemNo())
                    .memNickname(dto.getMemNickname()).build();
            return memRepo.updateMemNickname(member);
        }else{
            try{
                String fileName = "member/" + dto.getMemUsername() + "." + dto.getImage().getOriginalFilename().substring(dto.getImage().getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
                String imgSaveDir = new File("").getAbsolutePath() + "\\" + "/images/";
                File profileImg = new File(imgSaveDir + fileName);
                profileImg.getParentFile().mkdirs();
                dto.getImage().transferTo(profileImg);

                MemDto.Member member = MemDto.Member.builder()
                        .memNo(dto.getMemNo())
                        .imgPath(fileName)
                        .memNickname(dto.getMemNickname()).build();
                memRepo.updateMemNickname(member);
                memImgRepo.update(member);
                return 1;
            } catch (IOException e) {
                System.out.println(e);
                throw new MemberImageSaveFailException();
            }
        }
    }

    public Long findIdByMemUsername(String memUsername) {
        return memRepo.findIdByMemUsername(memUsername);
    }
}
