package com.hts.market.domain.member.repo;

import com.hts.market.domain.member.dto.MemDto;
import com.hts.market.domain.member.entity.MemEntity;
import org.apache.ibatis.annotations.Mapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class MemRepoTest {
    @Autowired MemRepo memRepo;

    //    // 회원가입
//    Integer save(MemDto.Create dto);
    @Test
    public void save(){
        // given ( 주어진 값 )
        MemDto.Create dto = MemDto.Create.builder()
                .memUsername("spring").memPassword("1234").memEmail("kimyk96@gmail.com")
                .memNickname("r김김ㄱ밈").memPhone(1027249409).memName("김용광").build();

        // when ( 그 값으로 뭔갈 했을때 )
        Integer result = memRepo.save(dto);

        // then ( 결과 )
        Assertions.assertThat(result).isEqualTo(1);

    }
    
//    // 새로 추가된 메소드
//
//    // 임시 회원가입
//    Integer saveTemp(MemDto.CreateTemp dto);
//
//    // 회원 조회(memUsername)
//    MemEntity loadUserByUsername(String memUsername);
//
//
//    // 이하 설계도에 있는 메소드
//
//    // 회원가입
//    Integer save(MemDto.Create dto);
//
//    // 회원 조회(memNo)
//    MemDto.Read findById(Long memNo);
//
//    // 회원 조회(memUsername)
//    MemDto.Read findByMemUsername(String memUsername);
//
//    // 회원 수정
//    Integer update(MemDto.Update dto);
//
//    // 회원 삭제
//    Integer delete(Long memNo);
//
//    // 회원명 중복검사
//    Integer countByMemUsername(String memUsername);
//
//    // 이메일 중복검사
//    Integer countByMemEmail(String memEmail);
//
//    // 닉네임 중복검사
//    Integer countByMemNickname(String memNickname);
//
//    // 전화번호 중복검사
//    Integer countByMemPhone(Integer memPhone);
//
//    // 비밀번호 업데이트
//    Integer updateMemPassword(String memPassword);
//
//    // 당도 검색
//    Integer findMemBrixByMemNo(Long memNo);
//
//    // 인증된 전화번호 추가
//    Integer updateMemPhoneById(MemDto.UpdatePhone dto);
//
//    // 로그인
//    Integer findByMemUsernameAndMemPassword(MemDto.Login dto);
}