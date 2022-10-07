package com.hts.market.domain.chat.repo;

import com.hts.market.domain.chat.dto.ChatDto;
import com.hts.market.domain.member.dto.AddressDto;
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


    @DisplayName("채팅저장")
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
    @DisplayName("채팅리스트&최근메세지")
    @Test
    public void findAllByChatMemNo() {
        //GIVEN
        Long chatMemNo = 1L;

        //WHEN
        List<ChatDto.Read> result = chatrepo.findAllByChatMemNo(chatMemNo);

        //THEN
            Assertions.assertThat(result).hasSize(21);

    }

    @DisplayName("회원간 채팅내역")
    @Test
    public void findAllByChatMemNoAndChatPdtNo() {
        //GIVEN
        ChatDto.scroll scroll = ChatDto.scroll.builder().chatMemNo(1L).chatPdtNo(1L).start(1).end(20).build();


        //WHEN
        List<ChatDto.Read> result = chatrepo.findAllByChatMemNoAndChatPdtNo(scroll);

        //THEN
        Assertions.assertThat(result).hasSize(20);
    }
}



