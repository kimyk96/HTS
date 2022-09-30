package com.hts.market.domain.product.app;

import com.hts.market.domain.product.repo.PdtRptRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PdtRptApp {
    @Autowired
    private PdtRptRepo pdtRptRepo;
}
