package com.petstore.service.impl;

import com.petstore.dao.ProductsDao;
import com.petstore.domain.Products;
import com.petstore.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private ProductsDao productsDao;
    @Override
    public void updateStatusById(Integer id, Integer status) {
        productsDao.updateStatusByProductId(id,status);
    }
    @Override
    public void ResetProductById(Integer id){
        productsDao.deleteProductById(id);
    }
    @Override
    public List<Products> getAllUnApproveProduct(Integer page){
        return productsDao.getAllUnApproveProduct(page);
    }
}
