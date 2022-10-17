package com.hts.market.domain.product.appTest;

import com.hts.market.domain.product.app.PdtImgApp;
import com.hts.market.domain.product.dto.PdtImgDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class PdtImgAppTest {
    @Autowired
    private PdtImgApp pdtImgApp;

    // 이미지 저장
    @BeforeEach
    void saveTest(){
        PdtImgDto.Create dto = PdtImgDto.Create.builder().pdtNo(1L).imgNo(1L).imgPath("1번글1번사진").build();

        Integer result = pdtImgApp.save(dto);

        Assertions.assertThat(result).isEqualTo(1);
    }
    // 이미지 수정
    @Test
    void updateTest(){
        PdtImgDto.Update dto = PdtImgDto.Update.builder().pdtNo(1L).imgNo(1L).imgPath("1번글1번사진수정").build();

        Integer result = pdtImgApp.update(dto);

        Assertions.assertThat(result).isEqualTo(1);
    }

    // 이미지 삭제
    @Test
    void deleteTest(){
        PdtImgDto.Delete dto = PdtImgDto.Delete.builder().imgNo(1L).pdtNo(1L).build();

        Integer result = pdtImgApp.delete(dto);

        Assertions.assertThat(result).isEqualTo(1);
    }
}
