//package com.hts.market.domain.member.repo;
//
//import com.hts.market.domain.member.dto.AddressDto;
//import com.hts.market.domain.member.dto.MemDto;
//import org.apache.ibatis.annotations.Mapper;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@SpringBootTest
//@Transactional
//public class AddressRepoTest {
//    @Autowired AddressRepo addressRepo;
//
//    // 기본 주소 생성(2명의 회원 각 2개씩)
//    @BeforeEach
//    public void beforeEach(){
//        AddressDto.Create dto1 = AddressDto.Create.builder()
//                .memNo(1L).addressSi("인천").addressGu("부평").addressDong("부평1").build();
//        AddressDto.Create dto2 = AddressDto.Create.builder()
//                .memNo(1L).addressSi("인천").addressGu("부평").addressDong("부평2").build();
//        AddressDto.Create dto3 = AddressDto.Create.builder()
//                .memNo(2L).addressSi("부산").addressGu("중").addressDong("평화1").build();
//        AddressDto.Create dto4 = AddressDto.Create.builder()
//                .memNo(2L).addressSi("부산").addressGu("중").addressDong("평화2").build();
//        addressRepo.save(dto1);
//        addressRepo.save(dto2);
//        addressRepo.save(dto3);
//        addressRepo.save(dto4);
//    }
//
//    // 이하 설계도에 있는 메소드
//    // 주소 저장
//    @Test
//    public void save(){
//        // given
//        AddressDto.Create dto = AddressDto.Create.builder()
//                .memNo(3L).addressSi("대전").addressGu("중").addressDong("문화").build();
//        // when
//        Integer result = addressRepo.save(dto);
//        // then
//        Assertions.assertThat(result).isEqualTo(1);
//    }
//    // 주소 조회
//    @Test
//    public void findById(){
//        // given
//        Long addressNo = 1L;
//        // when
//        AddressDto.Read result = addressRepo.findById(addressNo);
//        // then
//        Assertions.assertThat(result.getAddressNo()).isEqualTo(1L);
//        Assertions.assertThat(result.getAddressSi()).isEqualTo("인천");
//    }
//    // 회원별 주소 전체 조회
//    @Test
//    public void findAllById(){
//        // given
//        Long memNo = 1L;
//        // when
//        List<AddressDto.Read> result = addressRepo.findAllById(memNo);
//        // then
//        Assertions.assertThat(result).hasSize(2);
//        Assertions.assertThat(result.get(0).getAddressDong()).isEqualTo("부평1");
//    }
//    // 주소 수정
//    @Test
//    public void update(){
//        // given
//        AddressDto.Update dto = AddressDto.Update.builder()
//                .memNo(1L).addressNo(1L).addressSi("인천수정").addressGu("부평수정").addressDong("부평1수정").build();
//        // when
//        Integer result = addressRepo.update(dto);
//        // then
//        Assertions.assertThat(result).isEqualTo(1);
//    }
//    // 주소 삭제
//    @Test
//    public void delete(){
//        // given
//        AddressDto.Delete dto = AddressDto.Delete.builder()
//                .memNo(1L).addressNo(1L).build();
//        // when
//        Integer result = addressRepo.delete(dto);
//        // then
//        Assertions.assertThat(result).isEqualTo(1);
//    }
//}
