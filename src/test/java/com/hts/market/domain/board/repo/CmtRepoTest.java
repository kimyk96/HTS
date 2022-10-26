//package com.hts.market.domain.board.repo;
//
//import com.hts.market.domain.board.dto.CmtDto;
//import org.assertj.core.api.Assertions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
////@Transactional
//public class CmtRepoTest {
//    @Autowired
//    CmtRepo cmtRepo;
//
//        // 댓글 작성
//    //@Test
//    public void save() {
//        // given ( 주어진 값 )
//        CmtDto.Create dto = CmtDto.Create.builder()
//                .cmtContent("wnfmfcksdidgkfk").cmtWriterNo(1L).cmtBrdNo(1L).build();
//
//        // when ( 그 값으로 뭔갈 했을때 )
//        Integer result = cmtRepo.save(dto);
//
//        // then ( 결과 )
//        Assertions.assertThat(result).isEqualTo(1);
//
//    }
//
//    //@Test
//    public void update() {
//        CmtDto.Update dto = CmtDto.Update.builder()
//                .cmtNo(1L).cmtContent("wnfmfrudqogkfk").cmtWriterNo(1L).cmtBrdNo(1L).build();
//
//        Integer result = cmtRepo.update(dto);
//
//        Assertions.assertThat(result).isEqualTo(1);
//
//    }
//
////    @Test
////    public void delete() {
////        CmtDto.Delete dto = CmtDto.Delete.builder()
////                .cmtNo(1L).cmtWriterNo(1L).build();
////
////        Integer result = cmtRepo.delete(dto);
////
////        Assertions.assertThat(result).isEqualTo(1);
////
////    }
//
//}
//
