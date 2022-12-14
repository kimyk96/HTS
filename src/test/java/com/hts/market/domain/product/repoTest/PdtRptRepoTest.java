//package com.hts.market.domain.product.repoTest;
//
//import com.hts.market.domain.product.dto.PdtRptDto;
//import com.hts.market.domain.product.repo.PdtRptRepo;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//@SpringBootTest
//@Transactional
//class PdtRptRepoTest {
//    @Autowired
//    PdtRptRepo pdtRptRepo;
//
//    // 신고등록 테스트
//    @BeforeEach
//    void save(){
//        PdtRptDto.Create dto = PdtRptDto.Create.builder().rptMsgNo(1L).rptMemNo(1L).rptPdtNo(1L).build();
//
//        Integer result = pdtRptRepo.save(dto);
//
//        Assertions.assertThat(result).isEqualTo(1);
//    }
//    // 신고번호삭제 테스트
////    @Test
////    void deleteByRptNo(){
////        PdtRptDto.Delete dto = PdtRptDto.Delete.builder().rptNo(1L).build();
////
////        Integer result = pdtRptRepo.deleteByRptNo(dto);
////
////        Assertions.assertThat(result).isEqualTo(1);
////    }
////    // 신고회원별 삭제 테스트
////    @Test
////    void deleteByRptMemNo(){
////        PdtRptDto.Delete dto = PdtRptDto.Delete.builder().rptMemNo(1L).build();
////
////        Integer result = pdtRptRepo.deleteByRptMemNo(dto);
////
////        Assertions.assertThat(result).isEqualTo(1);
////    }
//    // 신고상품별 삭제 테스트
////    @Test
////    void deleteByRptPdtNo(){
////        Long dto = 1L;
////
////        Integer result = pdtRptRepo.deleteByRptPdtNo(dto);
////
////        Assertions.assertThat(result).isEqualTo(1);
//    }
//
//
//
//
