package com.hts.market.domain.product.repoTest;

import com.hts.market.domain.member.dto.AddressDto;
import com.hts.market.domain.member.repo.AddressRepo;
import com.hts.market.domain.product.dto.PdtDto;
import com.hts.market.domain.product.dto.PdtFavoriteDto;
import com.hts.market.domain.product.repo.PdtFavoriteRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
class PdtFavoriteRepoTest {
    @Autowired
    PdtFavoriteRepo pdtFavoriteRepo;
    @Autowired
    AddressRepo addressRepo;

    // 관심 등록 테스트
    @BeforeEach
    void saveTest() {
        PdtFavoriteDto.Create dto1 = PdtFavoriteDto.Create.builder().pdtNo(1L).memNo(1L).build();
        AddressDto.Create dto2 =
                AddressDto.Create.builder().memNo(1L).addressSi("인천광역시").addressGu("미추홀구").addressDong("학익2동").build();

        pdtFavoriteRepo.save(dto1);
        addressRepo.save(dto2);
    }
    // 관심 해제 테스트
    @Test
    void deleteTest(){
        PdtFavoriteDto.Delete dto = PdtFavoriteDto.Delete.builder().pdtNo(1L).memNo(1L).build();

        Integer result = pdtFavoriteRepo.delete(dto);

        Assertions.assertThat(result).isEqualTo(1);
    }
    // 관심 목록 테스트
    @Test
    void findAllByPdtNoTest(){
        PdtFavoriteDto.ReadList dto = PdtFavoriteDto.ReadList.builder().memNo(1L).build();

        List<PdtDto.ReadList> result = pdtFavoriteRepo.findAllOfFavoriteList(dto);

        Assertions.assertThat(result).hasSize(1);
    }

    // 관심수 확인
    @Test
    void countByPdtNoTest(){
        Long pdtNo = 1L;

        Integer result = pdtFavoriteRepo.countByPdtNo(pdtNo);

        Assertions.assertThat(result).isEqualTo(1);
    }
}
