package com.hts.market.domain.transaction.repo;

import com.hts.market.domain.member.dto.AddressDto;
import com.hts.market.domain.transaction.dto.TxDto;
import com.hts.market.domain.transaction.entity.TxEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@SpringBootTest
@Transactional
public class TxRepoTest {
    @Autowired
    TxRepo txRepo;
    @BeforeEach
    public void boforeEach(){
        TxDto.Create dto1 = TxDto.Create.builder()
                .txPdtNo(1L).txBuyerNo(1L).build();
        TxDto.Create dto2 = TxDto.Create.builder()
                .txPdtNo(2L).txBuyerNo(2L).build();
        txRepo.save(dto1);
        txRepo.save(dto2);
    }
    @Test
    public void save() {
        TxDto.Create dto = TxDto.Create.builder()
                .txPdtNo(1L).txBuyerNo(1L).build();

        Integer result = txRepo.save(dto);
        Assertions.assertThat(result).isEqualTo(1);
        Assertions.assertThat(result).isEqualTo(1);

    }

    @Test
    public void delete() {
        Integer txNo = txRepo.delete(1l);
        Assertions.assertThat(txNo).isEqualTo(1l);

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

     @Test
     public void findAllByMemNo() {
        // given
        Long txNo= 1L;
        // when
        List<TxDto.Read> result = txRepo.findAllByMemNo(txNo);
        // then
        Assertions.assertThat(result).hasSize(1);
         Assertions.assertThat(result.get(0).getTxPdtNo()).isEqualTo(1l);
    }

}




