package com.petstore.controller;

import com.petstore.controller.response.Response;
import com.petstore.domain.Cart;
import com.petstore.service.CartService;
import com.petstore.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/custom/cart")
public class CartController {
    @Autowired
    private SessionService sessionService;
    @Autowired
    private CartService cartService;
    @RequestMapping("/add")
    public Response addCart(@RequestParam(value = "productid")Integer productId,HttpSession session){
        Integer userid=sessionService.getUserSession(session);
        if(userid==null)return new Response(503,"未登录");
        Cart cart=cartService.insertCart(productId,userid);
        if(cart==null)return new Response(500,"网络错误");
        return new Response(200,cart,"ok");
    }
    @RequestMapping("/update")
    public Response updateCart(@RequestParam(value = "productid")Integer productId,@RequestParam(value = "number")Integer number,HttpSession session){
        Integer userid=sessionService.getUserSession(session);
        if(userid==null)return new Response(503,"未登录");
        Cart cart=cartService.updateCart(productId,userid,number);
        if(cart==null)return new Response(500,"网络错误");
        return new Response(200,cart,"ok");
    }
    @RequestMapping("/delete")
    public Response deleteCart(@RequestParam(value = "productid")Integer productId,HttpSession session) {
        Integer userid = sessionService.getUserSession(session);
        if (userid == null) return new Response(503, "未登录");
        cartService.deleteCart(productId,userid);
        return new Response(200,"ok");
    }
    @GetMapping("/get")
    public Response getCart(HttpSession session){
        Integer userid = sessionService.getUserSession(session);
        if (userid == null) return new Response(503, "未登录");
        List<Cart> carts=cartService.getCart(userid);
        return new Response(200,carts,"ok");
    }
}
