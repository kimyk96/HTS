//package com.hts.market.domain.product.repoTest;
//
//import com.hts.market.domain.member.dto.AddressDto;
//import com.hts.market.domain.member.repo.AddressRepo;
//import com.hts.market.domain.product.dto.PdtDto;
//import com.hts.market.domain.product.repo.PdtImgRepo;
//import com.hts.market.domain.product.repo.PdtRepo;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
//@SpringBootTest
//@Transactional
//class PdtRepoTest {
//    @Autowired
//    PdtRepo pdtRepo;
//    @Autowired
//    AddressRepo addressRepo;
//    @Autowired
//    PdtImgRepo pdtImgRepo;
//    // 판매글 작성 테스트
//    @BeforeEach
//    void saveTest() {
//        // given
//        PdtDto.Create dto1 =
//                PdtDto.Create.builder().pdtCateNo(1L).pdtSellerNo(1L).pdtAddressNo(1L).pdtName("상품").pdtDesc("설명").pdtPrice(7900).build();
//        AddressDto.Create dto2 =
//                AddressDto.Create.builder().memNo(1L).addressSi("인천광역시").addressGu("미추홀구").addressDong("학익2동").build();
////        PdtImgDto.Create dto3 =
////                PdtImgDto.Create.builder().pdtNo(1L).imgNo(1L).imgPath("1번사진").build();
////        PdtImgDto.Create dto4 =
////                PdtImgDto.Create.builder().pdtNo(1L).imgNo(1L).imgPath("2번사진").build();
////        PdtImgDto.Create dto5 =
////                PdtImgDto.Create.builder().pdtNo(1L).imgNo(1L).imgPath("3번사진").build();
//        // when
//        pdtRepo.save(dto1);
//        addressRepo.save(dto2);
////        pdtImgRepo.save(dto3);
////        pdtImgRepo.save(dto4);
////        pdtImgRepo.save(dto5);
//        // then
//    }
//    // 판매글 수정 테스트
//    @Test
//    void updateTest() {
//        PdtDto.Update dto =
//                PdtDto.Update.builder()
//                        .pdtNo(1l).pdtCateNo(2L).pdtAddressNo(1L).pdtName("수정상품").pdtStatus(1).pdtDesc("수정설명").pdtSellerNo(1L).pdtPrice(99000).build();
//
//        Integer result = pdtRepo.update(dto);
//
//        Assertions.assertThat(result).isEqualTo(0);
//
//    }
//
//    // 상품읽기 테스트
//    @Test
//    void findByPdtNo(){
//        Long pdtNo = 1L;
//
//        Optional<PdtDto.Detail> result = pdtRepo.findByPdtNo(pdtNo);
//
//        Assertions.assertThat(result);
//    }
//
//    // 조회수 테스트
//    @Test
//    void increaseViews(){
//        PdtDto.ViewCount dto = PdtDto.ViewCount.builder().pdtNo(1L).memNo(1L).build();
//
//        Integer result =  pdtRepo.increaseView(dto);
//
//        Assertions.assertThat(result).isEqualTo(1);
//    }
//    // 상품목록 테스트
//    @Test
//    void findAllByDataTest(){
//        PdtDto.ListData dto = PdtDto.ListData.builder().addressSi("인천광역시").addressGu("미추홀구").addressDong("학익2동").start(1).end(10).build();
//
//        List<PdtDto.ReadList> result = pdtRepo.findAllByData(dto);
//
//        Assertions.assertThat(result).hasSize(0);
//
//    }
//
//    // 상품 삭제
//    @Test
//    void deleteTest(){
//        PdtDto.Delete dto = PdtDto.Delete.builder().pdtNo(1L).pdtSellerNo(1L).build();
//
//        Integer result = pdtRepo.delete(dto);
//
//        Assertions.assertThat(result).isEqualTo(0);
//    }
//    // 상품 제목+내용으로 검색
//    @Test
//    void searchByKeywordTest(){
//        PdtDto.ListData dto = PdtDto.ListData.builder().addressSi("인천광역시").addressGu("미추홀구").addressDong("학익2동").start(1).end(10).keyword("1").build();
//
//        List<PdtDto.ReadList> result = pdtRepo.findAllByData(dto);
//
//        Assertions.assertThat(result).hasSize(0);
//    }
//
//    // 카테고리로 검색
//    @Test
//    void searchByCateLikeTest(){
//        PdtDto.ListData dto = PdtDto.ListData.builder().addressSi("인천광역시").addressGu("미추홀구").addressDong("학익2동").start(1).end(10).keyword("1").build();
//
//        List<PdtDto.ReadList> result = pdtRepo.findAllByData(dto);
//
//        Assertions.assertThat(result).hasSize(0);
//
//    }
//
//}
