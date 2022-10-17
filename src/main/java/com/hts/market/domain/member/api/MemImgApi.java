package com.hts.market.domain.member.api;

import com.hts.market.domain.member.app.MemImgApp;
import com.hts.market.domain.member.dto.MemImgDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.Part;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@Validated
@RequestMapping("/api/v1/mem-img")
public class MemImgApi {
    @Autowired MemImgApp memImgApp;

}
