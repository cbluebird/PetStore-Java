package com.petstore.service.impl;

import com.petstore.controller.receiver.customReceiver.Application;
import com.petstore.controller.receiver.customReceiver.Arry;
import com.petstore.dao.OrderDetailDao;
import com.petstore.dao.OrdersDao;
import com.petstore.dao.ProductsDao;
import com.petstore.domain.Orders;
import com.petstore.domain.OrdersDetails;
import com.petstore.domain.Products;
import com.petstore.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CustomServiceImpl implements CustomService {
    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private OrderDetailDao orderDetailDao;
    @Autowired
    private ProductsDao productsDao;

    @Override
    public Orders createOrder(Integer productId, String country, String city, String addr, String phone, Integer userid, Integer number, String name) {
        Products products = productsDao.selectById(productId);
        if (products.getVersion() + number <= products.getNumber()) {
            productsDao.purchase(productId, number);
            Orders orders = new Orders(userid, products.getPrice(), addr, city, country, phone, name);
            ordersDao.insert(orders);
            Integer orderId = ordersDao.getOrderId(userid);
            OrdersDetails ordersDetails = new OrdersDetails(orderId, productId, number, products.getPrice(), products.getShopid());
            orderDetailDao.insert(ordersDetails);
            return orders;
        }
        return null;
    }

    @Override
    public Products check(Arry arry) {
        Products products = productsDao.selectById(arry.productid);
        return (products.getVersion() + arry.number > products.getNumber()) ? null : products;
    }

    @Override
    public Orders createOrderInCart(Application application, Integer userid) {
        Boolean flag = true;
        List<Products> productsList = new ArrayList<>();
        for (int i = 0; i < application.product.length && flag; i++) {
            Arry arry = application.product[i];
            Products products = check(arry);
            if (products == null) flag = false;
            else productsList.add(products);
        }
        if (!flag) return null;
        Double money = 0.0;
        for (int i = 0; i < application.product.length && flag; i++)
            money += productsList.get(i).getPrice() * application.product[i].number;
        Orders orders = new Orders(userid, money, application.add, application.city, application.country, application.phone, application.name);
        ordersDao.insert(orders);
        Integer orderId = ordersDao.getOrderId(userid);
        for (int i = 0; i < application.product.length && flag; i++) {
            productsDao.purchase(application.product[i].productid, application.product[i].number);
            OrdersDetails ordersDetails = new OrdersDetails(orderId, application.product[i].productid,
                    application.product[i].number, productsList.get(i).getPrice() * application.product[i].number,
                    productsList.get(i).getShopid());
            orderDetailDao.insert(ordersDetails);
        }
        return orders;
    }

    @Override
    public List<Orders> uget(Integer userId, Integer page) {
        return ordersDao.getOrders(userId, page);
    }

    @Override
    public List<Orders> get(Integer userId, Integer page) {
        return ordersDao.getAllOrders(userId, page);
    }

    @Override
    public Boolean updateOrder(Integer orderId, Integer userid) {
        Orders orders = ordersDao.selectById(orderId);
        if (orders == null) return false;
        if (!Objects.equals(userid, orders.getUserid())) return false;
        ordersDao.updateOrder(orderId);
        return true;
    }
    @Override
    public List<OrdersDetails> getOrderByOrderId(Integer id){
        return orderDetailDao.getOrderById(id);
    }
}
