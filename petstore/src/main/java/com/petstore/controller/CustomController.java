package com.petstore.controller;

import com.petstore.controller.receiver.customReceiver.Application;
import com.petstore.controller.response.Response;
import com.petstore.domain.Orders;
import com.petstore.domain.OrdersDetails;
import com.petstore.service.CustomService;
import com.petstore.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/custom/")
public class CustomController {
    @Autowired
    private SessionService sessionService;
    @Autowired
    private CustomService customService;
    @PostMapping("/purchase")
    public Response purchase(@RequestParam("productid")Integer productId, @RequestParam("country")String country,
                             @RequestParam("city")String city,@RequestParam("addr")String addr,
                             @RequestParam("phone")String phone,@RequestParam("name")String name,HttpSession session){
        Integer userid=sessionService.getUserSession(session);
        if(userid==null)return new Response(503,"未登录");
        Orders orders=customService.createOrder(productId,country,city,addr,phone,userid,1,name);
        if(orders==null)return new Response(403,"没有货了");
        return new Response(200,orders,"ok");
    }
    @PostMapping("/cart/purchase")
    public Response cartPurchase(@RequestBody Application application, HttpSession session){
        Integer userid=sessionService.getUserSession(session);
        if(userid==null)return new Response(503,"未登录");
        Orders orders=customService.createOrderInCart(application,userid);
        if(orders==null)return new Response(403,"没有货了");
        return new Response(200,orders,"ok");
    }
    @GetMapping("/uget")
    public Response get(@RequestParam("page")Integer page,HttpSession session){
        Integer userid=sessionService.getUserSession(session);
        if(userid==null)return new Response(503,"未登录");
        Integer pages=(page-1)*10;
        List<Orders>orders=customService.uget(userid,pages);
        return new Response(200,orders,"ok");
    }
    @GetMapping("/get")
    public Response uget(@RequestParam("page")Integer page,HttpSession session){
        Integer userid=sessionService.getUserSession(session);
        if(userid==null)return new Response(503,"未登录");
        Integer pages=(page-1)*10;
        List<Orders>orders=customService.get(userid,pages);
        return new Response(200,orders,"ok");
    }
    @PostMapping("/order/update")
    public Response update(@RequestParam("orderid")Integer orderId,HttpSession session){
        Integer userid=sessionService.getUserSession(session);
        if(userid==null)return new Response(503,"未登录");
        Boolean flag=customService.updateOrder(orderId,userid);
        if(!flag)return new Response(404,"找不到相应的订单");
        return new Response(200,"ok");
    }
    @GetMapping("/order/get")
    public Response getOrder(@RequestParam("orderid")Integer orderId,HttpSession session){
        Integer userid=sessionService.getUserSession(session);
        if(userid==null)return new Response(503,"未登录");
        List<OrdersDetails>ordersDetails =customService.getOrderByOrderId(orderId);
        return new Response(200,ordersDetails,"ok");
    }
}
