package com.hts.market.domain.member.repo;

import com.hts.market.domain.member.dto.MemRoleDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class MemRoleRepoTest {
    @Autowired MemRoleRepo memRoleRepo;

    // 기본 유저 1명 = admin,user & 다른 1명 = user
    @BeforeEach
    public void beforeEach(){
        MemRoleDto.Create dto1 = MemRoleDto.Create.builder()
                .memNo(1L).roleNo(1L).build();
        MemRoleDto.Create dto2 = MemRoleDto.Create.builder()
                .memNo(1L).roleNo(2L).build();
        MemRoleDto.Create dto3 = MemRoleDto.Create.builder()
                .memNo(2L).roleNo(2L).build();
        memRoleRepo.save(dto1);
        memRoleRepo.save(dto2);
        memRoleRepo.save(dto3);
    }

    // 이하 설계도에 있는 메소드들
    // 회원 권한 추가
    @Test
    public void save(){
        // given
        MemRoleDto.Create dto = MemRoleDto.Create.builder()
                .memNo(3L).roleNo(2L).build();
        // when
        Integer result = memRoleRepo.save(dto);
        // then
        Assertions.assertThat(result).isEqualTo(1);
    }
    // 회원 권한 조회
    @Test
    public void findAllById(){
        // given
        Long memNo = 1L;
        // when
        List<MemRoleDto.Read> result = memRoleRepo.findAllById(memNo);
        // then
        Assertions.assertThat(result).hasSize(2);
    }
    // 회원 권한 삭제
    @Test
    public void delete(){
        // given
        MemRoleDto.Delete dto = MemRoleDto.Delete.builder()
                .memNo(2L).roleNo(2L).build();
        // when
        Integer result = memRoleRepo.delete(dto);
        // then
        Assertions.assertThat(result).isEqualTo(1);
    }
    // 회원 권한 전체 삭제
    @Test
    public void deleteAll(){
        // given
        Long memNo = 1L;
        // when
        Integer result = memRoleRepo.deleteAll(memNo);
        // then
        Assertions.assertThat(result).isEqualTo(2);
    }
}
