package com.hts.market.domain.product.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class PdtCateEntity {
    private long pdtCateNo;
    private String pdtCate;
}
