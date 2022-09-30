package com.hts.market.domain.product.app;

import com.hts.market.domain.product.repo.PdtImgRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PdtImgApp {
    @Autowired
    private PdtImgRepo pdtImgRepo;
}
