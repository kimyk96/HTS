package com.hts.market.domain.product.daoTest;

import com.hts.market.domain.product.dto.PdtFavoriteDto;
import com.hts.market.domain.product.repo.PdtFavoriteRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class PdtFavoriteRepoTest {
    @Autowired
    PdtFavoriteRepo pdtFavoriteRepo;

//  관심 등록 테스트
    @BeforeEach
    void saveTest() {
        PdtFavoriteDto.Create dto = PdtFavoriteDto.Create.builder().pdtNo(1L).memNo(1L).build();

        Integer result = pdtFavoriteRepo.save(dto);

        Assertions.assertThat(result).isEqualTo(1);

    }
// 관심 해제 테스트
    @Test
    void delete(){
        PdtFavoriteDto.Delete dto = PdtFavoriteDto.Delete.builder().pdtNo(1L).memNo(1L).build();

        Integer result = pdtFavoriteRepo.delete(dto);

        Assertions.assertThat(result).isEqualTo(1);
    }
// 관심 목록 테스트
//    @Test
//    void findAllByPdtNo(){
//        PdtFavoriteDto.ReadList dto = PdtFavoriteDto.ReadList.builder().memNo(1L).build();
//        Long memNo = 1;
//        List<PdtFavoriteDto.ReadList> result = pdtFavoriteRepo.findAllOfFavoriteList(memNo);
//
//        Assertions.assertThat(result).hasSize(1);
//    }

// 관심수 확인
    @Test
    void countByPdtNo(){
        PdtFavoriteDto.CountFavorite dto = PdtFavoriteDto.CountFavorite.builder().pdtNo(1L).build();

        Integer result = pdtFavoriteRepo.countByPdtNo(dto);

        Assertions.assertThat(result).isEqualTo(1);
    }
}
