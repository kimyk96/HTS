package com.hts.market.domain.board.repo;

import com.hts.market.domain.board.dto.BrdImgDto;
import com.hts.market.domain.board.dto.BrdRptDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@Transactional
public class BrdRptRepoTest {
    @Autowired
    BrdRptRepo brdRptRepo;
    //    // 신고
    @Test
    public void save() {
        // given
        BrdRptDto.Create dto = BrdRptDto.Create.builder()
                .rptBrdNo(1l).RptMsgNo(1l).rptMemNo(1l).build();
        // when
        Integer result = brdRptRepo.save(dto);
        // then
        Assertions.assertThat(result).isEqualTo(1);
    }



}

