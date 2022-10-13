//package com.hts.market.domain.member.repo;
//
//import com.hts.market.domain.member.dto.RoleDto;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//@SpringBootTest
//@Transactional
//public class RoleRepoTest {
//    @Autowired RoleRepo roleRepo;
//
//    // 기본 회원 권한 2개 -> ROLE_ADMIN = 1, ROLE_USER = 2
//    @BeforeEach
//    public void beforeEach(){
//        RoleDto.Create dto1 = RoleDto.Create.builder()
//                .roleName("ROLE_ADMIN").build();
//        RoleDto.Create dto2 = RoleDto.Create.builder()
//                .roleName("ROLE_USER").build();
//        roleRepo.save(dto1);
//        roleRepo.save(dto2);
//    }
//
//    // 권한 그룹 추가
//    @Test
//    public void save(){
//        // given
//        RoleDto.Create dto = RoleDto.Create.builder()
//                .roleName("ROLE_TEST").build();
//        // when
//        Integer result = roleRepo.save(dto);
//        // then
//        Assertions.assertThat(result).isEqualTo(1);
//    }
//    // 권한명 조회
//    @Test
//    public void findById(){
//        // given
//        Long roleNo = 1L;
//        // when
//        RoleDto.Read result = roleRepo.findById(1L);
//        // then
//        Assertions.assertThat(result.getRoleName()).isEqualTo("ROLE_ADMIN");
//    }
//    // 권한 번호 조회
//    @Test
//    public void findByRoleName() {
//        // given
//        String roleName = "ROLE_ADMIN";
//        // when
//        RoleDto.Read result = roleRepo.findByRoleName(roleName);
//        // then
//        Assertions.assertThat(result.getRoleNo()).isEqualTo(1L);
//    }
//}
