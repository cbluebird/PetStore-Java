package com.petstore.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestCustomService {
    @Autowired
    private CustomService customService;
    @Test
    void create(){
        customService.createOrder(12,"中国","宁波","cwb","110",8,1,"cwb");
    }
    @Test
    void update(){
        Boolean flag=customService.updateOrder(5,8);
        System.out.println(flag);
    }
}
