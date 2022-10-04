package com.hts.market.domain.chat.repo;

import com.hts.market.domain.chat.dto.ChatDto;
import com.hts.market.domain.chat.dto.ChatListDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ChatRepo {

    //채팅저장
    Integer save(ChatDto.Create creDto);

    //채팅내역불러오기
    List<ChatDto.Read> findByChatMemNo(ChatListDto.ListDto listDto);
    //회원 상품간 채팅내역
    List<ChatDto.Read> findAllByChatMemNoAndChatPdtNo(ChatListDto.ListDto listDto);

    //회원 채팅방 내역
    List<ChatDto.Read> findAllByChatMemNoAndChatPdtNoAndChatMsgNo(ChatListDto.ListDto listDto);

    // 최근메세지





}
