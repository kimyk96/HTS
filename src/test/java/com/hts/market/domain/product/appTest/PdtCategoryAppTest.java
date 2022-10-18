package com.hts.market.domain.product.appTest;

import com.hts.market.domain.product.app.PdtCateApp;
import com.hts.market.domain.product.dto.PdtCateDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class PdtCategoryAppTest {
    @Autowired
    private PdtCateApp pdtCateApp;

    @Test
    void findAll(){
        List<PdtCateDto.Read> result = pdtCateApp.findAll();
        Assertions.assertThat(result).hasSize(19);
    }
}
