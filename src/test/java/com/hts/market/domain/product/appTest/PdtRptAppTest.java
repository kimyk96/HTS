//package com.hts.market.domain.product.appTest;
//
//import com.hts.market.domain.product.app.PdtRptApp;
//import com.hts.market.domain.product.dto.PdtRptDto;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
////@Transactional
//public class PdtRptAppTest {
//    @Autowired
//    private PdtRptApp pdtRptApp;
//
//    // 신고 등록
//    @Test
//    void saveTest(){
//        String userName = "01000000000";
//        PdtRptDto.Create dto = PdtRptDto.Create.builder().rptPdtNo(1L).rptMsgNo(1L).build();
//        Integer result = pdtRptApp.save(dto, userName);
//        Assertions.assertThat(result).isEqualTo(1);
//    }
//    // 5회이상 신고받은 상품 삭제
//    @Test
//    void deleteOfPdt(){
//        Integer result = pdtRptApp.deleteByCount();
//        Assertions.assertThat(result).isEqualTo(1);
//    }
////
////    // 신고 목록 조회
////    @Test
////    void findAllByDto(){
////        PdtRptDto.Read dto = PdtRptDto.Read.builder().rptPdtNo(1L).build();
////        List<PdtRptDto.Read> result = pdtRptApp.findAllByDto(dto);
////        Assertions.assertThat(result).hasSize(1);
////    }
////
////    // 신고번호로 신고 삭제
////    @Test
////    void deleteByRptNo(){
////        PdtRptDto.Delete dto = PdtRptDto.Delete.builder().rptNo(1L).build();
////        Integer result = pdtRptApp.deleteByRptNo(dto);
////        Assertions.assertThat(result).isEqualTo(1);
////    }
////
////    // 회원번호로 신고 삭제
////    @Test
////    void deleteByRptMemNo(){
////        PdtRptDto.Delete dto = PdtRptDto.Delete.builder().rptMemNo(1L).build();
////        Integer result = pdtRptApp.deleteByRptMemNo(dto);
////        Assertions.assertThat(result).isEqualTo(0);
////    }
////
////    // 상품번호로 신고 삭제
////    @Test
////    void deleteByRptPdtNo(){
////        Long dto = 1L;
////        Integer result = pdtRptApp.deleteByRptPdtNo(dto);
////        Assertions.assertThat(result).isEqualTo(1);
////    }
//}
