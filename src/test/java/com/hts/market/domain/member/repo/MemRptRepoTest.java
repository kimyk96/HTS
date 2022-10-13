//package com.hts.market.domain.member.repo;
//
//import com.hts.market.domain.member.dto.MemRptDto;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//@SpringBootTest
//@Transactional
//public class MemRptRepoTest {
//    @Autowired MemRptRepo memRptRepo;
//
//    // 기본 신고 2개 생성
//    @BeforeEach
//    public void beforeEach(){
//        MemRptDto.Create dto1 = MemRptDto.Create.builder()
//                .rptMemNo(1L).rptMsgNo(1L).rptTargetNo(2L).build();
//        MemRptDto.Create dto2 = MemRptDto.Create.builder()
//                .rptMemNo(1L).rptMsgNo(2L).rptTargetNo(3L).build();
//        memRptRepo.save(dto1);
//        memRptRepo.save(dto2);
//    }
//    // 이하 설계도에 있는 메소드들
//    // 회원 신고
//    @Test
//    public void save(){
//        // given
//        MemRptDto.Create dto = MemRptDto.Create.builder()
//                .rptMemNo(2L).rptMsgNo(2L).rptTargetNo(3L).build();
//        // when
//        Integer result = memRptRepo.save(dto);
//        // then
//        Assertions.assertThat(result).isEqualTo(1);
//    }
//}
