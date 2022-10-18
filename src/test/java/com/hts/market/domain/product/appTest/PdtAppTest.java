package com.hts.market.domain.product.appTest;

import com.hts.market.domain.product.app.PdtApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class PdtAppTest {
    @Autowired
    PdtApp pdtApp;
//
//    @BeforeEach
//    void saveTest(){
//        PdtDto.Create dto = PdtDto.Create.builder().build();
//    }
}
