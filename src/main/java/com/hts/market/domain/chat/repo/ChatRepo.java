package com.hts.market.domain.chat.repo;

import com.hts.market.domain.chat.dto.ChatDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Mapper
public interface ChatRepo {
    // 채팅저장
    public Integer save(ChatDto.Create creDto);

    // 회원 채팅방 목록 및 메세지 불러오기
    public List<ChatDto.Pk> findAllByChatMemNo(Long chatMemNo);

    // 회원간 채팅내역
    public List<ChatDto.Read> findAllByChatMemNoAndChatPdtNo(ChatDto.ListStartEnd listStartEnd);

    //상품별 채팅 수
    public Integer countChatByPdtNo(Long pdtNo);

    // 상품별 관심
    public boolean countChatByPdtNoAndMemNo (Long chatPdtNo, Long chatMemNo);






}
