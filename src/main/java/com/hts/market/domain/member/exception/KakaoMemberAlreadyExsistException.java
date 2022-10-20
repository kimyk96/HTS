package com.hts.market.domain.member.exception;

import com.hts.market.domain.member.dto.MemDto;
import lombok.Getter;

public class KakaoMemberAlreadyExsistException extends RuntimeException{
    @Getter private final MemDto.Member member;
    public KakaoMemberAlreadyExsistException(MemDto.Member member){
        this.member = member;
    }
}
