package com.hts.market.domain.product.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class PdtCateEntity {
    private Long pdtCateNo;
    private String pdtCate;
}
