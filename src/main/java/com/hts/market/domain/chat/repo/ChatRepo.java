package com.hts.market.domain.chat.repo;

import com.hts.market.domain.chat.dto.ChatDto;
import com.hts.market.domain.chat.dto.ChatListDto;

import java.util.List;

public interface ChatRepo {

    //채팅저장
    Integer save(ChatDto.Create creDto);

    //채팅내역불러오기
    List<ChatDto.Read> findAllById(ChatListDto.ListDto listDto);


}
