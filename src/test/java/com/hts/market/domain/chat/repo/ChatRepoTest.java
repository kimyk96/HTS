package com.hts.market.domain.chat.repo;

import com.hts.market.domain.chat.dto.ChatDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class ChatRepoTest {
    @Autowired
    ChatRepo chatrepo;

    @BeforeEach
    public void beforeEach() {

        for (Integer i = 0; i < 21; i++) {
            //given
            ChatDto.Create dto = ChatDto.Create.builder()
                    .chatMemNo(1L).chatPdtNo(1L).chatContent(i.toString()).build();

            // when
            Integer result = chatrepo.save(dto);
        }


    }


    @DisplayName("1)채팅저장")
    @Test
    public void save() {

        //given
        ChatDto.Create dto = ChatDto.Create.builder()
                .chatMemNo(1L).chatPdtNo(1L).chatContent("test1").build();

        // when
        Integer result = chatrepo.save(dto);

        //then
        Assertions.assertThat(result).isEqualTo(1);
    }
    @DisplayName("2)채팅리스트&최근메세지")
    @Test
    public void findAllByChatMemNo() {
        //GIVEN
        Long chatMemNo = 1L;

        //WHEN
        List<ChatDto.Pk> result = chatrepo.findAllByChatMemNo(chatMemNo);

        //THEN
        Assertions.assertThat(result).hasSize(21);

    }

    @DisplayName("3)회원간 채팅내역")
    @Test
    public void findAllByChatMemNoAndChatPdtNo() {
        //GIVEN
        ChatDto.ListStartEnd listStartEnd = ChatDto.ListStartEnd.builder().chatMemNo(1L).chatPdtNo(1L).start(1).end(20).build();


        //WHEN
        List<ChatDto.Read> result = chatrepo.findAllByChatMemNoAndChatPdtNo(listStartEnd);

        //THEN
        Assertions.assertThat(result).hasSize(20);
    }

    @DisplayName("4)회원 관심")
    @Test
    public void countChatByPdtNoAndMemNo (){
        //GIVEN

        //WHEN

        //THEN
    }
}



