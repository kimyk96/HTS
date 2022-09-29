package com.hts.market.domain.member.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Builder @ToString
public class MemEntity {
<<<<<<<<< Temporary merge branch 1

}
=========
    private Long memNo;
    private String memUsername;
    private String memPassword;
    private String memName;
    private String memNickname;
    private String memEmail;
    private Integer memPhone;
    private Integer memBrix;
    private Integer memIsEnabled;
    private LocalDateTime memCreatedAt;
}
>>>>>>>>> Temporary merge branch 2
