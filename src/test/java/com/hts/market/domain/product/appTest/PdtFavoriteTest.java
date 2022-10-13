package com.hts.market.domain.product.appTest;

import com.hts.market.domain.product.app.PdtFavoriteApp;
import com.hts.market.domain.product.dto.PdtFavoriteDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class PdtFavoriteTest {
    @Autowired
    private PdtFavoriteApp pdtFavoriteApp;

    // 관심등록 테스트
    @BeforeEach
    void saveTest(){
        PdtFavoriteDto.Create dto = PdtFavoriteDto.Create.builder().pdtNo(1L).memNo(1L).build();

        Integer result = pdtFavoriteApp.save(dto);

        Assertions.assertThat(result).isEqualTo(1);
    }

    // 관심해제 테스트
    @Test
    void deleteTest(){
        PdtFavoriteDto.Delete dto = PdtFavoriteDto.Delete.builder().pdtNo(1L).memNo(1L).build();

        Integer result = pdtFavoriteApp.delete(dto);
        Assertions.assertThat(result).isEqualTo(1);
    }

    // 회원별 관심목록 보기

    // 상품별 관심수
}
