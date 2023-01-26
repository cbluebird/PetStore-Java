package com.petstore.service;

import com.petstore.domain.Products;

import java.util.List;

public interface AdminService {
    void updateStatusById(Integer productid,Integer status);
    void ResetProductById(Integer id);
    List<Products> getAllUnApproveProduct(Integer page);
}
