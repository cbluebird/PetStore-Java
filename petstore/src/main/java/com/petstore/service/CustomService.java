package com.petstore.service;

import com.petstore.controller.receiver.customReceiver.Application;
import com.petstore.controller.receiver.customReceiver.Arry;
import com.petstore.domain.Orders;
import com.petstore.domain.OrdersDetails;
import com.petstore.domain.Products;

import java.util.List;

public interface CustomService {
    Orders createOrder(Integer productId,String country,String city,String addr,String phone,Integer userid,Integer number,String name);
    Products check(Arry arry);
    Orders createOrderInCart(Application application, Integer userid);
    List<Orders> get(Integer userId, Integer page);
    List<Orders>uget(Integer userId,Integer page);
    Boolean updateOrder(Integer id,Integer userid);
    List<OrdersDetails> getOrderByOrderId(Integer id);
}
