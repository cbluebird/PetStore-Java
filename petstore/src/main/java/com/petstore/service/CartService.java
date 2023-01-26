package com.petstore.service;

import com.petstore.domain.Cart;

import java.util.List;

public interface CartService {
    Cart insertCart(Integer productId, Integer userId);
    Cart updateCart(Integer productId,Integer userId,Integer number);
    void deleteCart(Integer productId,Integer userId);
    List<Cart> getCart(Integer userid);
}
