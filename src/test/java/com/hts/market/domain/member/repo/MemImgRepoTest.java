package com.hts.market.domain.member.repo;

import com.hts.market.domain.member.dto.MemImgDto;
import org.apache.ibatis.annotations.Mapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.codec.multipart.Part;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class MemImgRepoTest {
    @Autowired MemImgRepo memImgRepo;

    // 기본 이미지 생성 (2개)
    @BeforeEach
    public void beforeEach() {
        MemImgDto.Create dto1 = MemImgDto.Create.builder()
                .memNo(1L).imgPath("이미지경로1").build();
        MemImgDto.Create dto2 = MemImgDto.Create.builder()
                .memNo(2L).imgPath("이미지경로2").build();
        memImgRepo.save(dto1);
        memImgRepo.save(dto2);
    }


    // 이하 설계도에 있는 메소드들
    // 회원 이미지 추가
    @Test
    public void save() {
        // given
        MemImgDto.Create dto = MemImgDto.Create.builder()
                .memNo(3L).imgPath("이미지경로3").build();
        // when
        Integer result = memImgRepo.save(dto);
        // then
        Assertions.assertThat(result).isEqualTo(1);
    }

    // 회원 이미지 조회
    @Test
    public void findById() {
        // given
        MemImgDto.Read dto = MemImgDto.Read.builder()
                .memNo(1L).imgNo(1L).build();
        // when
        MemImgDto.Read result = memImgRepo.findById(dto);
        // then
        Assertions.assertThat(result.getImgPath()).isEqualTo("이미지경로1");
    }

    // 회원 이미지 수정
    @Test
    public void update() {
        // given
        MemImgDto.Update dto = MemImgDto.Update.builder()
                .memNo(1L).imgNo(1L).imgPath("수정이미지경로1").build();
        // when
        Integer result = memImgRepo.update(dto);
        // then
        Assertions.assertThat(result).isEqualTo(1);
    }

    // 회원 이미지 삭제
    @Test
    public void delete() {
        // given
        MemImgDto.Delete dto = MemImgDto.Delete.builder()
                .memNo(1L).imgNo(1L).build();
        // when
        Integer result = memImgRepo.delete(dto);
        // then
        Assertions.assertThat(result).isEqualTo(1);
    }
}