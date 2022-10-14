package com.hts.market.domain.board.repo;

import com.hts.market.domain.board.dto.BrdDto;
import com.hts.market.domain.board.dto.BrdImgDto;
import com.hts.market.domain.member.dto.MemImgDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
//@Transactional
public class BrdImgRepoTest {
    @Autowired
    BrdImgRepo brdImgRepo;

    //    // 이미지등록
    //@Test
    public void save() {
        // given
        BrdImgDto.Create dto = BrdImgDto.Create.builder()
                .brdNo(1L).imgPath("이미지경로1").build();
        // when
        Integer result = brdImgRepo.save(dto);
        // then
        Assertions.assertThat(result).isEqualTo(1);
    }

    //@Test
    public void update() {
        BrdImgDto.Update dto = BrdImgDto.Update.builder()
                .imgNo(1l).brdNo(1l).imgPath("rudfhdkseody").build();

        Integer result = brdImgRepo.update(dto);

        Assertions.assertThat(result).isEqualTo(1l);

    }

    @Test
    public void delete() {
        BrdImgDto.Delete dto = BrdImgDto.Delete.builder()
                .brdNo(1L).imgNo(1l).build();

        Integer result = brdImgRepo.delete(dto);

        Assertions.assertThat(result).isEqualTo(1);

    }


}

