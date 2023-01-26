package com.petstore.service;

import com.petstore.domain.Products;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestUniversalController {
    @Autowired
    private UniversalService universalService;
    @Test
    void getAll(){
        universalService.getAll(0);
    }
    @Test
    void getShopProducts(){
        universalService.getShopProducts(6,10);
    }

    @Test
    void getCategory(){
        universalService.getCategory();
    }
    @Test
    void getCategoryProducts(){
        universalService.getCategoryProduct("猫",0);
    }
    @Test
    void getShopCategoryProduct(){
        universalService.getShopCategoryProduct("狗",0,5);
    }
}
