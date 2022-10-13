package com.hts.market.domain.member.entity;

import lombok.*;

import java.time.LocalDateTime;


@Getter @Builder @ToString
public class MemEntity {
    private Long memNo;
    private String memUsername;
    private String memPassword;
    private String memNickname;
    private String memEmail;
    private Integer memBrix;
    private Integer memIsEnabled;
    private LocalDateTime memCreatedAt;
}
