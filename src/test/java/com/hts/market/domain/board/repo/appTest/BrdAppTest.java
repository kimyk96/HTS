package com.hts.market.domain.board.repo.appTest;


import com.hts.market.domain.board.app.BrdApp;
import com.hts.market.domain.board.app.BrdLikeApp;
import com.hts.market.domain.board.app.CmtApp;
import com.hts.market.domain.board.dto.BrdDto;
import com.hts.market.domain.board.dto.BrdLikeDto;
import com.hts.market.domain.board.dto.CmtDto;
import com.hts.market.domain.member.dto.AddressDto;
import com.hts.market.domain.member.dto.MemDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
class BrdAppTest {

    @Autowired BrdApp brdApp;
    @Autowired BrdLikeApp brdLikeApp;
    @Autowired CmtApp cmtApp;

    @BeforeEach
    void saveTest() {
        String username = "00000000000";
        BrdDto.Create dto1 = BrdDto.Create.builder().brdCateNo(1l).brdContent("aslijdal").brdTitle("adasda").build();
        BrdLikeDto.Create dto2 = BrdLikeDto.Create.builder().brdNo(1L).build();
        CmtDto.Create dto3 = CmtDto.Create.builder().cmtContent("dwqdqajw").cmtBrdNo(1L).build();
        AddressDto.Create dto4 = AddressDto.Create.builder().addressSi("시").addressGu("구").addressDong("동").memNo(1L).build();
        // when ( 그 값으로 뭔갈 했을때 )
        brdApp.save(dto1, username);
        brdLikeApp.save(dto2, username);
        cmtApp.save(dto3, username);


        // then ( 결과 )
//        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    void readTest() {
        Long brdNo = 1L;
        String username = "00000000000";

        BrdDto.Detail result = brdApp.findByBrdNo(brdNo, username);

        Assertions.assertThat(result.getBoard().getBrdNo()).isEqualTo(1);

    }

    @Test
    void updateTest() {
        String username = "00000000000";
        BrdDto.Update dto1 = BrdDto.Update.builder().brdNo(1l).brdCateNo(1l).brdContent("t수정").brdTitle("수정").build();
        Integer result = brdApp.update(dto1, username);

        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    void deleteTest() {
        String username = "00000000000";
        BrdDto.Delete dto = BrdDto.Delete.builder().brdNo(1l).build();
        Integer result = brdApp.delete(dto, username);

        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    void ReadListTest() {
        String username = "00000000000";
        BrdDto.ListData dto = BrdDto.ListData.builder().start(1).end(10).addressSi("시").addressGu("구").addressDong("동").build();

        List<BrdDto.ReadList> result = brdApp.findAllByData(dto, username);

        Assertions.assertThat(result).isEmpty();
    }
}
