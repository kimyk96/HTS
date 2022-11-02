package com.hts.market.global.app;

import com.hts.market.global.dto.RptMsgDto;
import com.hts.market.global.repo.RptMsgRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RptMsgApp {
    @Autowired
    RptMsgRepo rptMsgRepo;

    public List<RptMsgDto> findAll() {
        return rptMsgRepo.findAll();
    }
}
