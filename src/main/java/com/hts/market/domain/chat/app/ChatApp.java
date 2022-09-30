package com.hts.market.domain.chat.app;

import com.hts.market.domain.chat.dto.ChatDto;
import com.hts.market.domain.chat.exception.NonUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ChatApp {
    @Autowired
    public Integer save(ChatDto.Create creDto) {
        return null;
    };

    public List<ChatDto.Read> findAllByChatMsgNo() {
        return null;
    }
}
