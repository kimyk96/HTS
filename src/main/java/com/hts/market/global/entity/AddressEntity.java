package com.hts.market.global.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class AddressEntity {
    private Long addressNo;
    private Long memNo;
    private String addressSi;
    private String addressGu;
    private String addressDong;
}
