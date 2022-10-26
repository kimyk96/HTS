//package com.hts.market.domain.product.apiTest;
//
//import com.hts.market.domain.product.api.PdtCateApi;
//import com.hts.market.domain.product.dto.PdtCateDto;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.ResponseEntity;
//
//import java.util.List;
//
//@SpringBootTest
//public class PdtCateApiTest {
//    @Autowired
//    PdtCateApi pdtCateApi;
//
//    //
//    @Test
//    void findAll(){
//        ResponseEntity<List<PdtCateDto.Read>> result = pdtCateApi.findAll();
//        Assertions.assertThat(result.getBody()).hasSize(19);
//        Assertions.assertThat(result.getStatusCodeValue()).isEqualTo(200);
//    }
//}
