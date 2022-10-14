package com.hts.market.domain.member.app;

import com.hts.market.domain.member.dto.MemImgDto;
import com.hts.market.domain.member.repo.MemImgRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.multipart.Part;
import org.springframework.stereotype.Service;

@Service
public class MemImgApp {
    @Autowired MemImgRepo memImgRepo;


}
