package com.hts.market.domain.product.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class PdtImgEntity {
    private Long pdtNo;
    private Long imgNo;
    private String imgPath;
}
