package com.hts.market.domain.board.api;


import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/api/v1/brd-img")
@Secured("ROLE_USER")
public class BrdImgApi {
}
