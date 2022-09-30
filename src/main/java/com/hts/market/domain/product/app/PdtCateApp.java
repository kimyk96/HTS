package com.hts.market.domain.product.app;

import com.hts.market.domain.product.repo.PdtCateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PdtCateApp {
    @Autowired
    private PdtCateRepo pdtCateRepo;
}
