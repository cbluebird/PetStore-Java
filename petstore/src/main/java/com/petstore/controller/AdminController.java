package com.petstore.controller;

import com.petstore.controller.receiver.adminRecviver.AdminApproveData;
import com.petstore.controller.response.Response;
import com.petstore.domain.Products;
import com.petstore.service.AdminService;
import com.petstore.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private SessionService sessionService;
    @Autowired
    private AdminService adminService;
    @PostMapping("/approve")
    public Response approve(@RequestBody AdminApproveData adminApproveData, HttpSession session){
        Integer userid=sessionService.getAdminSession(session);
        if(userid==null)return new Response(503,"未登录");
        adminService.updateStatusById(adminApproveData.productid,adminApproveData.status);
        return new Response(200,"ok");
    }
    @GetMapping("/delete")
    public Response delete(@RequestParam("productid")Integer productId,HttpSession session){
        Integer userid=sessionService.getAdminSession(session);
        if(userid==null)return new Response(503,"未登录");
        adminService.ResetProductById(productId);
        return new Response(200,"ok");
    }
    @GetMapping("/unapprove")
    public Response unApprove(@RequestParam("page")Integer page,HttpSession session){
        Integer userid=sessionService.getAdminSession(session);
        if(userid==null)return new Response(503,"未登录");
        Integer pages=(page-1)*10;
        List<Products> a =adminService.getAllUnApproveProduct(pages);
        return new Response(200,a,"ok");
    }
}
