package com.hts.market.domain.member.repo;

import com.hts.market.domain.member.dto.MemDto;
import com.hts.market.domain.member.entity.MemEntity;
import org.apache.ibatis.annotations.Mapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class MemRepoTest {
    @Autowired MemRepo memRepo;

    // 기본 회원 생성(3명)
    @BeforeEach
    public void beforeEach(){
        MemDto.Create dto1 = MemDto.Create.builder()
                .memUsername("spring").memPassword("1234").memEmail("spring@gmail.com")
                .memNickname("spring").memPhone(1011111111).memName("spring").build();
        MemDto.Create dto2 = MemDto.Create.builder()
                .memUsername("summer").memPassword("1234").memEmail("summer@gmail.com")
                .memNickname("summer").memPhone(1022222222).memName("summer").build();
        MemDto.Create dto3 = MemDto.Create.builder()
                .memUsername("winter").memPassword("1234").memEmail("winter@gmail.com")
                .memNickname("winter").memPhone(1022222222).memName("winter").build();
        memRepo.save(dto1);
        memRepo.save(dto2);
        memRepo.save(dto3);
    }

    // 새로 추가된 메소드
    // 임시 회원가입
    @Test
    public void saveTemp(){
        // given
        MemDto.CreateTemp dto = MemDto.CreateTemp.builder().build();
        // when
        Integer result = memRepo.saveTemp(dto);
        // then
        Assertions.assertThat(result).isEqualTo(1);
        Assertions.assertThat(dto.getMemNo()).isEqualTo(4);
    }
    // 회원 조회(memUsername)
    @Test
    public void loadUserByUsername(){
        // given
        String memUsername = "spring";
        // when
        MemEntity result = memRepo.loadUserByUsername(memUsername);
        // then
        Assertions.assertThat(result.getMemUsername()).isEqualTo(memUsername);
    }

    // 이하 설계도에 있는 메소드
    // 회원가입
    @Test
    public void save(){
        // given
        MemDto.Create dto = MemDto.Create.builder()
                .memUsername("spring").memPassword("1234").memEmail("spring@gmail.com")
                .memNickname("김용광").memPhone(1011111111).memName("김용광").build();
        // when
        Integer result = memRepo.save(dto);
        // then
        Assertions.assertThat(result).isEqualTo(1);
    }
    // 회원 조회(memNo)
    @Test
    public void findById(){
        // given
        Long memNo = 1L;
        // when
        MemDto.Read result = memRepo.findById(memNo);
        // then
        Assertions.assertThat(result.getMemNo()).isEqualTo(memNo);
    }
    // 회원 조회(memUsername)
    @Test
    public void findByMemUsername(){
        // given
        String memUsername = "spring";
        // when
        MemDto.Read result = memRepo.findByMemUsername(memUsername);
        // then
        Assertions.assertThat(result.getMemUsername()).isEqualTo(memUsername);
    }
    // 회원 수정
    @Test
    public void update(){
        // given
        MemDto.Update dto = MemDto.Update.builder()
                .memNo(1L).memEmail("newemail@gmail.com").memNickname("newNickName").build();
        // when
        Integer result = memRepo.update(dto);
        // then
        Assertions.assertThat(result).isEqualTo(1);
    }
    // 회원 삭제
    @Test
    public void delete(){
        // given
        Long memNo = 1L;
        // when
        Integer result = memRepo.delete(memNo);
        // then
        Assertions.assertThat(result).isEqualTo(1);
    }
    // 회원명 중복검사
    @Test
    public void countByMemUsername(){
        // given
        String memUsername = "spring";
        // when
        Integer result = memRepo.countByMemUsername(memUsername);
        // then
        Assertions.assertThat(result).isEqualTo(1);
    }
    // 이메일 중복검사
    @Test
    public void countByMemEmail(){
        // given
        String memEmail = "spring@gmail.com";
        // when
        Integer result = memRepo.countByMemEmail(memEmail);
        // then
        Assertions.assertThat(result).isEqualTo(1);
    }
    // 닉네임 중복검사
    @Test
    public void countByMemNickname(){
        // given
        String memNickname = "spring";
        // when
        Integer result = memRepo.countByMemNickname(memNickname);
        // then
        Assertions.assertThat(result).isEqualTo(1);
    }
    // 전화번호 중복검사
    @Test
    public void countByMemPhone(){
        // given
        Integer memPhone = 1011111111;
        // when
        Integer result = memRepo.countByMemPhone(memPhone);
        // then
        Assertions.assertThat(result).isEqualTo(1);
    }
    // 비밀번호 업데이트
    @Test
    public void updateMemPassword(){
        // given
        MemDto.Update dto = MemDto.Update.builder().memNo(1L).memPassword("newPass").build();
        // when
        Integer result = memRepo.updateMemPassword(dto);
        // then
        Assertions.assertThat(result).isEqualTo(1);
    }
    // 당도 검색
    @Test
    public void findMemBrixByMemNo(){
        // given
        Long memNo = 1L;
        // when
        Integer result = memRepo.findMemBrixByMemNo(memNo);
        // then
        Assertions.assertThat(result).isEqualTo(10); // brix default 값은 10
    }
    // 인증된 전화번호 추가
    @Test
    public void updateMemPhoneById(){
        // given
        MemDto.UpdatePhone dto = MemDto.UpdatePhone.builder().memNo(1L).memPhone(1023232323).build();
        // when
        Integer result = memRepo.updateMemPhoneById(dto);
        // then
        Assertions.assertThat(result).isEqualTo(1);
    }
}