package com.petstore.service;

import com.petstore.domain.Products;

import java.util.List;

public interface UniversalService {
    List<Products> getAll(Integer pages);
    List<Products> getShopProducts(Integer shopId,Integer page);
    List<String> getCategory();
    List<Products> getCategoryProduct(String category,Integer page);
    List<Products> getShopCategoryProduct(String category,Integer page,Integer shopId);
    Products getProduct(Integer id);
}
