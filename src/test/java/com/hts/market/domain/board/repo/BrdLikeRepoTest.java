//package com.hts.market.domain.board.repo;
//
//import com.hts.market.domain.board.dto.BrdImgDto;
//import com.hts.market.domain.board.dto.BrdLikeDto;
//import com.hts.market.domain.product.dto.PdtFavoriteDto;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
////@Transactional
//public class BrdLikeRepoTest {
//    @Autowired
//    BrdLikeRepo brdLikeRepo;
//
//    // 이미지등록
//    //@Test
//    public void save() {
//        BrdLikeDto.Create dto = BrdLikeDto.Create.builder()
//                .brdNo(2L).memNo(2L).build();
//
//        Integer result = brdLikeRepo.save(dto);
//
//        Assertions.assertThat(result).isEqualTo(1);
//    }
//
//    @Test
//    public void delete() {
//        BrdLikeDto.Delete dto = BrdLikeDto.Delete.builder().brdNo(2L).memNo(2L).build();
//
//        Integer result = brdLikeRepo.delete(dto);
//
//        Assertions.assertThat(result).isEqualTo(1);
//
//    }
//
//
//
//    }
//
//
