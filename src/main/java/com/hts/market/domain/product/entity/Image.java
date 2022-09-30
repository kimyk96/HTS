package com.hts.market.domain.product.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class Image {
    private long pdtNo;
    private long pdtImgNo;
    private String putImgPath;
}
