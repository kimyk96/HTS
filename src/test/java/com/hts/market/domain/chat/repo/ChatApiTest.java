package com.hts.market.domain.chat.repo;

import com.hts.market.domain.chat.api.ChatApi;
import com.hts.market.domain.chat.app.ChatApp;
import com.hts.market.domain.chat.dto.ChatDto;
import com.sun.mail.imap.ResyncData;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.transform.Result;
import java.security.Principal;
import java.util.List;

@SpringBootTest
@Transactional
public class ChatApiTest {
    @Autowired ChatApi chatapi;




//    @BeforeEach
//    public void beforeEach() {
//
//        for (Integer i = 0; i < 21; i++) {
//            //given
//            ChatDto.Create dto = ChatDto.Create.builder()
//                    .chatMemNo(1L).chatPdtNo(1L).chatContent(i.toString()).build();
//
//            // when
//            ResponseEntity<Integer> result = chatapi.save(dto,);
//        }
//

//    }


//        @DisplayName("1)메세지 보내기")
//        @Test
//        public void save() {
//            //GIVEN
//            ChatDto.Create dto = ChatDto.Create.builder().chatPdtNo(1L).chatContent("안녕하세요").chatMemNo(1L).build();
//
//            //WHEN
//            ResponseEntity<Integer> result = chatapi.save(dto);
//
//            //THEN
//            Assertions.assertThat(result.getStatusCodeValue()).isEqualTo(200);
//
//
//        }


//    @DisplayName("2)채팅리스트&최근메세지")
//     @Test
//    public void findAllByChatMemNo() {
//        //GIVEN
//        Long chatMemNo = 1L;
//
//        //WHEN
//        ResponseEntity<List<ChatDto.Pk>> result = chatapi.findAllByChatMemNo(chatMemNo);
//
//        //THEN
//        ResponseEntity.ok(result);
//    }


//    @DisplayName("3)회원간 채팅내역")
//   @WithUserDetails("00000000")
//    @Test
//    public void findAllByChatMemNoAndChatPdtNo() {
//        //GIVEN
//        ChatDto.ListStartEnd listStartEnd = ChatDto.ListStartEnd.builder().chatMemNo(1L).chatPdtNo(1L).start(1).end(20).build();
//
//
//        //WHEN
//        ResponseEntity<List<ChatDto.Read>> result = chatapi.findAllByChatMemNoAndChatPdtNo(listStartEnd,Principal);
//
//        //THEN
//        System.out.println("결과 : " + result);
//  }

    @DisplayName("4)회원 관심")
    @Test
    public void countChatByPdtNoAndMemNo (){
        //GIVEN
       ChatDto.ChatLike chatLike = ChatDto.ChatLike.builder().chatMemNo(1L).chatPdtNo(1L).build();
        //WHEN
        ResponseEntity<Boolean> result = chatapi.countChatByPdtNoAndMemNo(chatLike);
        //THEN
        Assertions.assertThat(result.getBody()).isTrue();

        System.out.println("Result : " + result);

   }

    @DisplayName("5)상품별 메세지 카운트")
    @Test
    public void countChatByPdtNo(){
        //GIVEN
        Long dto = 1L;
        //WHEN
        ResponseEntity<Integer> result = chatapi.countChatByPdtNo(dto);
        //THEN
        Assertions.assertThat(result.getBody()).isEqualTo(1);

        System.out.println("Result : " + result);

    }


}



