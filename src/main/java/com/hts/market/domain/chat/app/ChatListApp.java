package com.hts.market.domain.chat.app;

import com.hts.market.domain.chat.api.ChatApi;
import com.hts.market.domain.chat.dto.ChatDto;
import com.hts.market.domain.chat.dto.ChatListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatListApp {
    @Autowired ChatApi chatApi;

    public Integer save(ChatListDto chatListDto) {

    }

    public List<ChatDto.Read> findAllByPage(String username) {
    }

    public Integer delete(Integer chatNo) {
    }
}
