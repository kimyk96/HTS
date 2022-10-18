package com.hts.market.domain.product.apiTest;

import com.hts.market.domain.product.api.PdtFavoriteApi;
import com.hts.market.domain.product.dto.PdtFavoriteDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.TestExecutionEvent;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;

@SpringBootTest
@Transactional
public class PdtFavoriteApiTest {
    @Autowired
    PdtFavoriteApi pdtFavoriteApi;

    @BeforeEach
    @WithUserDetails(value = "00000000" , setupBefore = TestExecutionEvent.TEST_EXECUTION)
    void saveTest(){
        PdtFavoriteDto.Create dto = PdtFavoriteDto.Create.builder().pdtNo(1L).memNo(1L).build();

        Principal WithUserDetails = null;

        pdtFavoriteApi.save(dto, null);
    }

    @Test
    void deleteTest(){
        PdtFavoriteDto.Delete dto = PdtFavoriteDto.Delete.builder().build();
    }
}
