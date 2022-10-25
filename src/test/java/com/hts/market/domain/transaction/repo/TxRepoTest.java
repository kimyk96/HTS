package com.hts.market.domain.transaction.repo;

import com.hts.market.domain.member.dto.AddressDto;
import com.hts.market.domain.member.dto.MemDto;
import com.hts.market.domain.member.repo.AddressRepo;
import com.hts.market.domain.member.repo.MemRepo;
import com.hts.market.domain.product.dto.PdtDto;
import com.hts.market.domain.product.repo.PdtCateRepo;
import com.hts.market.domain.product.repo.PdtImgRepo;
import com.hts.market.domain.product.repo.PdtRepo;
import com.hts.market.domain.transaction.dto.TxDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Transactional
public class TxRepoTest {
    @Autowired
    TxRepo txRepo;
    @Autowired
    PdtRepo pdtRepo;
    @Autowired
    PdtImgRepo pdtImgRepo;
    @Autowired
    AddressRepo addressRepo;
    @Autowired
    PdtCateRepo pdtCateRepo;
    @Autowired
    MemRepo memRepo;
    @BeforeEach
    public void boforeEach(){
        PdtDto.Create dto1 =
                PdtDto.Create.builder().pdtCateNo(1L).pdtSellerNo(1L).pdtAddressNo(1L).pdtName("상품").pdtDesc("설명").pdtPrice(7900).build();
        AddressDto.Create dto2 =
                AddressDto.Create.builder().memNo(1L).addressSi("인천").addressGu("부평").addressDong("부평1").build();
       /* PdtImgDto.Create dto3 =
                PdtImgDto.Create.builder().pdtNo(1L).imgNo(1l).imgPath("abc123").build();
        PdtCateDto.Create dto4 = PdtCateDto.Create.builder().pdtCate("가전").build();*/

        TxDto.Create dto5 = TxDto.Create.builder()
                .txPdtNo(1L).txBuyerNo(1L).build();
        TxDto.Create dto6 = TxDto.Create.builder()
                .txPdtNo(2L).txBuyerNo(2L).build();
        MemDto.Create dto7 = MemDto.Create.builder().memUsername("asd").memPassword("1234").memEmail("pig026@naver.com").memNickname("주호").memIsEnabled(1).build();
        pdtRepo.save(dto1);
        addressRepo.save(dto2);
//        pdtImgRepo.save(dto3);
//        pdtCateRepo.save(dto4);
        txRepo.save(dto5);
        txRepo.save(dto6);
        memRepo.save(dto7);
    }
    @Test
    public void save() {
        TxDto.Create dto = TxDto.Create.builder()
                .txPdtNo(4L).txBuyerNo(4L).build();

        Integer result = txRepo.save(dto);
        Assertions.assertThat(result).isEqualTo(1);
        Assertions.assertThat(result).isEqualTo(1);

    }

    @Test
    public void delete() {
        Integer txNo = txRepo.delete(0L);
        Assertions.assertThat(txNo).isEqualTo(0);

    }

    @Test
    public void findById() {
        // given
        Long txNo = 2L;
        // when
        TxDto.Read result = txRepo.findById(txNo);
        // then
        Assertions.assertThat(result.getTxNo()).isEqualTo(txNo);
    }

//     @Test
//     public void findSaleListByMemNo() {
//        // given
//        Long memNo= 1L;
//        // when
//        Optional<List<TxDto.Read>> result = txRepo.findSaleListByMemNo(memNo);
//        // then
//        Assertions.assertThat(result);
//
//    }
//   @Test
//    public void findPurchaseListByMemNo() {
//        // given
//        Long memNo= 1L;
//        // when
//        Optional<List<TxDto.Read>> result = txRepo.findPurchaseListByMemNo(memNo);
//        // then
//        Assertions.assertThat(result);
//
//    }

}




