package com.hts.market.domain.product.app;

import com.hts.market.domain.product.repo.PdtRepo;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PdtApp {
    @Autowired
    private PdtRepo pdtRepo;

    public Integer save() {
        return null;
    }
}
