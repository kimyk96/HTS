package com.hts.market.domain.product.daoTest;

import com.hts.market.domain.product.dto.PdtImgDto;
import com.hts.market.domain.product.repo.PdtImgRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class PdtImgRepoTest {
    @Autowired
    PdtImgRepo pdtImgRepo;


    //이미지 저장 테스트
    @BeforeEach
    void save(){
        PdtImgDto.Create dto = PdtImgDto.Create.builder().pdtNo(1L).imgNo(1L).imgPath("stInDf1241").build();

        Integer result = pdtImgRepo.save(dto);

        Assertions.assertThat(result).isEqualTo(1);
    }

    //이미지 수정 테스트
   @Test
    void update(){
        PdtImgDto.Update dto = PdtImgDto.Update.builder().pdtNo(1L).imgNo(1L).imgPath("수정경로").build();

        Integer result = pdtImgRepo.update(dto);

        Assertions.assertThat(result).isEqualTo(1);
    }

    //이미지 삭제 테스트
    @Test
    void delete(){
        PdtImgDto.Delete dto = PdtImgDto.Delete.builder().pdtNo(1L).imgNo(1L).build();

        Integer result = pdtImgRepo.delete(dto);

        Assertions.assertThat(result).isEqualTo(1);


    }
}
