package com.hts.market.domain.product.daoTest;

import com.hts.market.domain.product.dto.PdtRptDto;
import com.hts.market.domain.product.repo.PdtRptRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
class PdtRptRepoTest {
    @Autowired
    PdtRptRepo pdtRptRepo;

    // 신고등록 테스트
    @BeforeEach
    void save(){
        PdtRptDto.Create dto = PdtRptDto.Create.builder().rptMsgNo(1L).rptMemNo(1L).rptPdtNo(1L).build();

        Integer result = pdtRptRepo.save(dto);

        Assertions.assertThat(result).isEqualTo(1);
    }

    // 신고목록 출력 테스트
    @Test
    void findAllByDto(){
        PdtRptDto.Read dto = PdtRptDto.Read.builder().rptPdtNo(1L).build();
        List<PdtRptDto.Read> result = pdtRptRepo.findAllByDto(dto);
        Assertions.assertThat(result).hasSize(1);
    }

    // 신고번호삭제 테스트
    @Test
    void deleteByRptNo(){
        PdtRptDto.Delete dto = PdtRptDto.Delete.builder().rptNo(1L).build();

        Integer result = pdtRptRepo.deleteByRptNo(dto);

        Assertions.assertThat(result).isEqualTo(1);
    }
    // 신고회원별 삭제 테스트
    @Test
    void deleteByRptMemNo(){
        PdtRptDto.Delete dto = PdtRptDto.Delete.builder().rptMemNo(1L).build();

        Integer result = pdtRptRepo.deleteByRptMemNo(dto);

        Assertions.assertThat(result).isEqualTo(1);
    }
    // 신고상품별 삭제 테스트
    @Test
    void deleteByRptPdtNo(){
        PdtRptDto.Delete dto = PdtRptDto.Delete.builder().rptPdtNo(1L).build();

        Integer result = pdtRptRepo.deleteByRptPdtNo(dto);

        Assertions.assertThat(result).isEqualTo(1);
    }




}
