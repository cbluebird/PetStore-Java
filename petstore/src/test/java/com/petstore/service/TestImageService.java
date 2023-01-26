package com.petstore.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestImageService {
    @Autowired
    private ImagesService imagesService;
    @Test
    void create(){
        imagesService.createPortrait(3);
    }
}
