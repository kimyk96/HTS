package com.hts.market.domain.prduct;

import com.hts.market.domain.member.dto.AddressDto;
import com.hts.market.domain.member.repo.AddressRepo;
import com.hts.market.domain.product.dto.PdtCateDto;
import com.hts.market.domain.product.dto.PdtDto;
import com.hts.market.domain.product.dto.PdtImgDto;
import com.hts.market.domain.product.repo.PdtCateRepo;
import com.hts.market.domain.product.repo.PdtImgRepo;
import com.hts.market.domain.product.repo.PdtRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
class PdtRepoTest {
    @Autowired
    PdtRepo pdtRepo;
    @Autowired
    AddressRepo addressRepo;
    @Autowired
    PdtCateRepo pdtCateRepo;
    @Autowired
    PdtImgRepo pdtImgRepo;
    // 판매글 작성 테스트
    @BeforeEach
    void saveTest() {
        // given
        PdtDto.Create dto1 =
                PdtDto.Create.builder().pdtCateNo(1L).pdtSellerNo(1L).pdtAddressNo(1L).pdtName("상품").pdtStatus(1).pdtDesc("설명").pdtPrice(7900).build();
        AddressDto.Create dto2 =
                AddressDto.Create.builder().memNo(1L).addressSi("인천").addressGu("부평").addressDong("부평1").build();
        PdtImgDto.Create dto3 =
                PdtImgDto.Create.builder().pdtNo(1L).imgPath("abc123").build();
        PdtCateDto.Create dto4 = PdtCateDto.Create.builder().pdtCate("가전").build();
        // when
        pdtRepo.save(dto1);
        addressRepo.save(dto2);
        pdtImgRepo.save(dto3);
        pdtCateRepo.save(dto4);
        // then
    }
    // 판매글 수정 테스트
    @Test
    void updateTest() {
        PdtDto.Update dto =
                PdtDto.Update.builder()
                        .pdtNo(1l).pdtCateNo(2L).pdtAddressNo(1L).pdtName("수정상품").pdtStatus(1).pdtDesc("수정설명").pdtPrice(99000).build();

        Integer result = pdtRepo.update(dto);

        Assertions.assertThat(result).isEqualTo(1);

    }
    // 판매글 죄회수증가 테스트
    @Test
    void increaseInViewsTest(){
        PdtDto.ViewCount dto = PdtDto.ViewCount.builder().pdtNo(1L).pdtSellerNo(2L).build();

        Integer views = pdtRepo.increaseInViews(dto);

        Assertions.assertThat(views).isEqualTo(1);
    }
    // 상품읽기 테스트
    @Test
    void findByPdtNo(){
        PdtDto.Read dto = PdtDto.Read.builder().pdtNo(1L).build();

        PdtDto.Read result = pdtRepo.findByPdtNo(dto);

        Assertions.assertThat(result.getPdtNo()).isEqualTo(1L);
    }
    // 지역별 상품목록 테스트
    @Test
    void findAllByAddressTest(){
        PdtDto.AddressData dto = PdtDto.AddressData.builder().addressSi("인천").addressGu("부평").addressDong("부평1").start(1).end(1).build();

        List<PdtDto.ReadList> result = pdtRepo.findAllByAddress(dto);

        Assertions.assertThat(result).hasSize(1);

    }

    // 상품 삭제
    @Test
    void deleteTest(){
        PdtDto.Delete dto = PdtDto.Delete.builder().pdtNo(1L).build();

        Integer result = pdtRepo.delete(dto);

        Assertions.assertThat(result).isEqualTo(1);
    }
    // 상품 제목+내용으로 검색
    @Test
    void searchByKeywordTest(){
        PdtDto.SearchData dto = PdtDto.SearchData.builder().addressSi("인천").addressGu("부평").addressDong("부평1").start(1).end(1).pdtName("상").pdtDesc("").build();

        List<PdtDto.ReadList> result = pdtRepo.searchByKeywordLike(dto);

        Assertions.assertThat(result).hasSize(1);
    }

    // 카테고리로 검색
    @Test
    void searchByCateLikeTest(){
        PdtDto.SearchData dto = PdtDto.SearchData.builder().addressSi("인천").addressGu("부평").addressDong("부평1").start(1).end(1).pdtCate("가").build();

        List<PdtDto.ReadList> result = pdtRepo.searchByKeywordLike(dto);

        Assertions.assertThat(result).hasSize(1);

    }

}
