package com.petstore.service;

import com.petstore.controller.response.Shop.OrderForShop;
import com.petstore.domain.Products;

import java.util.List;

public interface SellerService {
    Integer CreateProducts(Products products);
    Boolean CheckProduct(Integer productId,Integer shopId);
    Boolean deleteProductById(Integer productId);
    List<OrderForShop> getOrder(Integer userid);
    Boolean update(Integer userid,Products products);
    Boolean updateNumber(Integer number,Integer productId);
    Integer getNewProduct(Integer shopId);
}
