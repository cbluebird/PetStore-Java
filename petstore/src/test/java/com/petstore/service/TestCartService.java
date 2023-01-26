package com.petstore.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestCartService {
    @Autowired
    private CartService cartService;
    @Test
    void insert(){
        cartService.insertCart(19,8);
    }
    @Test
    void update(){
        cartService.updateCart(19,8,4);
    }
    @Test
    void get(){
        cartService.getCart(8);
    }
}
