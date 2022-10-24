package com.hts.market.global.api;

import com.hts.market.global.app.ImageApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
@RequestMapping("/images")
public class ImageApi {
    @Autowired ImageApp imageApp;

    @GetMapping(path="/{dir}/{img}", produces= MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> findByPath(@PathVariable String dir, @PathVariable String img) {
        return imageApp.findByPath(dir, img);
    }
}
