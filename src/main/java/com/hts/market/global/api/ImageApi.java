package com.hts.market.global.api;

import com.hts.market.global.app.ImageApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/images")
public class ImageApi {
    @Autowired ImageApp imageApp;
    
    // 이미지 불러오기
    @GetMapping(path = "/{dir}/{img}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> findByPath(@PathVariable String dir, @PathVariable String img) {
        return imageApp.findByPath(dir, img);
    }
}
