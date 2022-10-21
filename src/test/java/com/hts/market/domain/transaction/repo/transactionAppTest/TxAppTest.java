package com.hts.market.domain.transaction.repo.transactionAppTest;

import com.hts.market.domain.member.dto.AddressDto;
import com.hts.market.domain.member.dto.MemDto;
import com.hts.market.domain.member.repo.AddressRepo;
import com.hts.market.domain.member.repo.MemRepo;
import com.hts.market.domain.product.dto.PdtDto;
import com.hts.market.domain.product.repo.PdtRepo;
import com.hts.market.domain.transaction.dto.TxDto;
import com.hts.market.domain.transaction.repo.TxRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
public class TxAppTest {
   @Autowired
    TxRepo txRepo;
    @Autowired
    PdtRepo pdtRepo;
    @Autowired
    AddressRepo addressRepo;
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
        MemDto.Create dto7 = MemDto.Create.builder().memUsername("asd").memPassword("1234").memEmail("pig026@naver.com").memNickname("주호주호니").build();
        pdtRepo.save(dto1);
        addressRepo.save(dto2);
//        pdtImgRepo.save(dto3);
//        pdtCateRepo.save(dto4);
        txRepo.save(dto5);
        txRepo.save(dto6);
        memRepo.save(dto7);
    }
    @Test
    void findPurchaseListByMemNo(){
        TxDto.Read dto=TxDto.Read.builder().txNo(1l).txBuyerNo(1l).txPdtNo(1l).build();
        Optional<List<TxDto.Read>> result=txRepo.findPurchaseListByMemNo(dto.getTxBuyerNo());
        Assertions.assertThat(result);
    }
    @Test
    void findSaleListByMemNo(){
        PdtDto.Read dto= PdtDto.Read.builder().pdtSellerNo(1L).build();
        Optional<List<TxDto.Read>> result=txRepo.findSaleListByMemNo(dto.getPdtSellerNo());
        Assertions.assertThat(result);
    }
    @Test
    void findByTxNo(){
        TxDto.Read dto=TxDto.Read.builder().txNo(1l).txBuyerNo(1l).txPdtNo(1l).build();
        TxDto.Read result=txRepo.findById(dto.getTxNo());
        Assertions.assertThat(result);
    }

}
