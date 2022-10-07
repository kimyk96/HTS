package com.hts.market.domain.chat.repo;

import com.hts.market.domain.chat.dto.ChatDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChatRepo {
    // 채팅저장
    public Integer save(ChatDto.Create creDto);

    // 회원 채팅방 목록 및 메세지 불러오기
    public List<ChatDto.Read> findAllByChatMemNo(Long chatMemNo);

    // 회원간 채팅내역
    public List<ChatDto.Read> findAllByChatMemNoAndChatPdtNo(ChatDto.scroll scroll);


}
