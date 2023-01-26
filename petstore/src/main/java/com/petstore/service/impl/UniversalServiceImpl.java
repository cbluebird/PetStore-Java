package com.petstore.service.impl;

import com.petstore.dao.ProductsDao;
import com.petstore.domain.Products;
import com.petstore.service.UniversalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversalServiceImpl implements UniversalService {
    @Autowired
    private ProductsDao productsDao;
    @Override
    public List<Products> getAll(Integer pages){
        return productsDao.getAllProducts(pages);
    }
    @Override
    public List<Products> getShopProducts(Integer shopId,Integer page){
        return productsDao.getShopProducts(shopId,page);
    }
    @Override
    public List<String> getCategory(){
        return productsDao.getCategory();
    };
    @Override
    public List<Products> getCategoryProduct(String category,Integer page){
        return productsDao.getCategoryProducts(category,page);
    }
    @Override
    public List<Products> getShopCategoryProduct(String category,Integer page,Integer shopId){
        return productsDao.getShopCategoryProducts(category,page,shopId);
    }
    @Override
    public Products getProduct(Integer id){
        return productsDao.selectById(id);
    }
}
