package com.hts.market.global.app;

import com.hts.market.domain.chat.dto.ChatDto;
import com.hts.market.domain.member.repo.MemRepo;
import com.hts.market.domain.product.repo.PdtRepo;
import com.hts.market.global.dto.MessageDto;
import com.hts.market.global.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class WebSocketApp {
    @Autowired MemRepo memRepo;
    @Autowired PdtRepo pdtRepo;

    // 메세지 보내기
    public MessageDto send(Message message) {
        Long from           = memRepo.findIdByMemUsername(message.getFrom());
        Long chatPdtNo      = Long.parseLong(message.getPdtNo());
        Long chatMemNo      = Long.parseLong(message.getMemNo());
        Long to             = from.equals(chatMemNo) ? pdtRepo.findSellerNoById(chatPdtNo) : chatMemNo;

        MessageDto msg = MessageDto.builder()
                .chatPdtNo(chatPdtNo)
                .chatMemNo(chatMemNo)
                .target(memRepo.findMemUsernameById(to))
                .now(LocalDateTime.now())
                .msg(message.getMsg())
                .build();
        return msg;
    }
}
