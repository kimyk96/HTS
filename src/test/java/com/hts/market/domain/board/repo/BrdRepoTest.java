package com.hts.market.domain.board.repo;

import com.hts.market.domain.board.dto.BrdDto;
import com.hts.market.domain.member.dto.AddressDto;
import com.hts.market.domain.member.dto.MemDto;
import com.hts.market.domain.member.repo.MemRepo;
import com.hts.market.domain.product.dto.PdtDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;

@SpringBootTest
@Transactional
public class BrdRepoTest {
    @Autowired
    BrdRepo brdRepo;

    //    // 회원가입
    @BeforeEach
    public void save() {
        // given ( 주어진 값 )
        BrdDto.Create dto = BrdDto.Create.builder()
                .brdTitle("zz").brdWriterNo(1L).brdContent("zlzzzlz").brdCateNo(1L).build();

        // when ( 그 값으로 뭔갈 했을때 )
        Integer result = brdRepo.save(dto);

        // then ( 결과 )
        Assertions.assertThat(result).isEqualTo(1);

    }

    //@Test
    public void update() {
        BrdDto.Update dto = BrdDto.Update.builder()
                .brdNo(1L).brdTitle("수정").brdContent("수정요").brdCateNo(2L).build();

        Integer result = brdRepo.update(dto);

        Assertions.assertThat(result).isEqualTo(1);

    }

    //@Test
    public void delete() {
        BrdDto.Delete dto = BrdDto.Delete.builder()
                .brdNo(2L).brdWriterNo(1L).build();

        Integer result = brdRepo.delete(dto);

        Assertions.assertThat(result).isEqualTo(1);

    }

    //@Test
    public void findByBrdNo() {
        // given
        Long brdNo = 1L;
        // when
//        BrdDto.Read result = brdRepo.findByBrdNo(brdNo);
        // then
//        Assertions.assertThat(result.getBrdNo()).isEqualTo(1L);

    }
//     @Test
//    public void findViewsByBrdNo() {
//        // given
//        BrdDto.ViewCount dto = BrdDto.ViewCount.builder().brdNo(2L).brdWriterNo(1L).build();
//
//        // when
//        Integer views = brdRepo.findViewsByBrdNo(dto);
//        // then
//        Assertions.assertThat(views).isEqualTo(0);
//
//    }
    //@Test
    public void findCreatedAtByBrdNo() {
        // given
//        Long brdNo = 1L;
//        // when
//        Date result = brdRepo.searchByKeyword(brdNo);
//        // then
//        Assertions.assertThat(result);

    }


    //@Test
//    public void findCateNoByBrdNo() {
//        // given
//        Long brdNo = 1L;
//        // when
//        Long result = brdRepo.findCateNoByBrdNo(brdNo);
//        // then
//        Assertions.assertThat(result).isEqualTo(1L);
//
//    }

}

