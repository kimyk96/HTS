//package com.hts.market.domain.product.repoTest;
//
//import com.hts.market.domain.product.dto.PdtCateDto;
//import com.hts.market.domain.product.repo.PdtCateRepo;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@SpringBootTest
//@Transactional
//class PdtCateRepoTest {
//    @Autowired
//    PdtCateRepo pdtCateRepo;
//
//    @Test
//    void  findAll(){
//        List<PdtCateDto.Read> result = pdtCateRepo.findAll();
//        Assertions.assertThat(result).hasSize(19);
//    }
//}
