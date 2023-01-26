package com.petstore.service.impl;

import com.petstore.controller.response.Shop.OrderForShop;
import com.petstore.dao.OrderDetailDao;
import com.petstore.dao.OrdersDao;
import com.petstore.dao.ProductsDao;
import com.petstore.domain.Orders;
import com.petstore.domain.OrdersDetails;
import com.petstore.domain.Products;
import com.petstore.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private ProductsDao productsDao;
    @Autowired
    private OrderDetailDao orderDetailDao;
    @Autowired
    private OrdersDao ordersDao;
    @Override
    public Integer CreateProducts(Products products){
        System.out.println(products);
        if(productsDao.insert(products)>0)return 200;
        return 500;
    }
    @Override
    public Boolean CheckProduct(Integer productId,Integer shopId){
        Products products=productsDao.selectById(productId);
        return products != null && Objects.equals(products.getShopid(), shopId);
    }
    @Override
    public Boolean deleteProductById(Integer productId){
        return productsDao.deleteById(productId)>0;
    }
    @Override
    public List<OrderForShop> getOrder(Integer userid){
        List<OrdersDetails>ordersDetails=orderDetailDao.getOrders(userid);
        List<OrderForShop>orderForShopList=new ArrayList<>();
        for(OrdersDetails i:ordersDetails){
            OrderForShop orderForShop=new OrderForShop();
            orderForShop.orderid=i.getOrderid();
            Orders orders=ordersDao.selectById( orderForShop.orderid);
            if(orders.getStatus()==1)continue;
            orderForShop.num=i.getNumber();
            orderForShop.productid=i.getProductid();
            orderForShop.productname=productsDao.getNameByid(orderForShop.productid);
            orderForShop.add=orders.getAddr();
            orderForShop.customname=orders.getName();
            orderForShop.city=orders.getCity();
            orderForShop.country=orders.getCountry();
            orderForShopList.add(orderForShop);
        }
        return orderForShopList;
    }
    @Override
    public Boolean update(Integer userid,Products products){
        Products products1=productsDao.selectById(products.getId());
        if(!Objects.equals(products1.getShopid(),userid))return false;
        return productsDao.updateById(products)>0;
    }
    @Override
    public Boolean updateNumber(Integer number,Integer productId){
        Products products=productsDao.selectById(productId);
        Integer now=products.getNumber()+number;
        if(now<products.getVersion())return false;
        products.setNumber(now);
        return productsDao.updateById(products)>0;
    }
    @Override
    public Integer getNewProduct(Integer shopId){
        return productsDao.getNewProduct(shopId);
    }
}
