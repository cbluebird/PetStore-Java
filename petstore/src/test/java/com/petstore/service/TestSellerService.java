package com.petstore.service;

import com.petstore.domain.Products;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestSellerService {
    @Autowired
    private SellerService sellerService;
    @Test
    void createProduct(){
        Products products=new Products("猫","小猫","/zhang.jpg","可爱的小猫",40.20,5,1);
        sellerService.CreateProducts(products);
    };
    @Test
    void check(){
        System.out.println(sellerService.CheckProduct(40,5));
    }
    @Test
    void get(){
        System.out.println(sellerService.getOrder(6));
    }
}
