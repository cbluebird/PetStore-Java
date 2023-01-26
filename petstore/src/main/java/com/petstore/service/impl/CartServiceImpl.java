package com.petstore.service.impl;

import com.petstore.dao.CartDao;
import com.petstore.dao.ProductsDao;
import com.petstore.domain.Cart;
import com.petstore.domain.Products;
import com.petstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private ProductsDao productsDao;
    @Autowired
    private CartDao cartDao;
    @Override
    public Cart insertCart(Integer productId,Integer userId){
        Cart cart=cartDao.getCartByUseridAndProductId(userId,productId);
        Products products=productsDao.selectById(productId);
        if(cart==null){
            cart=new Cart(userId,productId,1,products.getPrice());
            cartDao.insert(cart);
        }else{
            Integer number=cart.getNumber()+1;
            Double price=number*products.getPrice();
            cartDao.updateCart(number,price,userId,productId);
            cart.setNumber(number);
            cart.setUnitcost(price);
        }
        return cart;
    }
    @Override
    public Cart updateCart(Integer productId,Integer userId,Integer number){
        Cart cart=cartDao.getCartByUseridAndProductId(userId,productId);
        Products products=productsDao.selectById(productId);
        Double price=number*products.getPrice();
        cartDao.updateCart(number,price,userId,productId);
        cart.setNumber(number);
        cart.setUnitcost(price);
        return cart;
    }
    @Override
    public void deleteCart(Integer productId,Integer userId){
        cartDao.deleteCart(userId,productId);
    }
    @Override
    public List<Cart> getCart(Integer userid){
        return cartDao.getCart(userid);
    }
}
