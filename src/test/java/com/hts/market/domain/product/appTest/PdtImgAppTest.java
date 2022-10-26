//package com.hts.market.domain.product.appTest;
//
//import com.hts.market.domain.product.app.PdtImgApp;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.io.IOException;
//
//@SpringBootTest
//@Transactional
//public class PdtImgAppTest {
//    @Autowired
//    private PdtImgApp pdtImgApp;
//
//    // 이미지 저장
//    @BeforeEach
//    void saveTest(){
//        // given
//
//        // when
//
//        // then
//
//    }
//    // 이미지 수정
//    @Test
//    void updateTest(){
//        // given
//
////        MultipartFile file = new File();
//        // when
//
//        // then
//
//    }
//
//    // 이미지 삭제
//    @Test
//    void deleteTest() throws IOException {
//        Long pdtNo = 1L;
//
//        Integer result = pdtImgApp.deleteAll(pdtNo);
//
//        Assertions.assertThat(result).isEqualTo(1);
//    }
//}
