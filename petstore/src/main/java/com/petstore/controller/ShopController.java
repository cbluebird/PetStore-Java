package com.petstore.controller;

import com.petstore.controller.receiver.shopReceiver.DeleteData;
import com.petstore.controller.response.Response;
import com.petstore.controller.response.Shop.OrderForShop;
import com.petstore.domain.Products;
import com.petstore.domain.User;
import com.petstore.service.ImagesService;
import com.petstore.service.SellerService;
import com.petstore.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/shop")
public class ShopController {
    @Autowired
    private SessionService sessionService;
    @Autowired
    private SellerService sellerService;
    @Autowired
    private ImagesService imagesService;
    @Value(("${web.upload-path}"))
    private String uploadPath;
    @PostMapping("/submit")
    public Response submit(@RequestParam(value = "image") MultipartFile file, @RequestParam(value = "category")String category,
                           @RequestParam(value ="name")String name, @RequestParam(value ="desc")String desc,
                           @RequestParam(value ="price")Double price, @RequestParam(value ="number")Integer number,
                           HttpSession session){
        Integer userid=sessionService.getSellerSession(session);
        if(userid==null)return new Response(503,"未登录");
        Products products=new Products(category,name,desc,price,number,userid);
        sellerService.CreateProducts(products);
        Integer id=sellerService.getNewProduct(userid);
        String visibleUri=imagesService.saveImage(file,id);
        imagesService.updateImage(visibleUri,id);
        return new Response(200,"ok");
    }
    @PostMapping("/deleteproduct")
    public Response delete(@RequestBody DeleteData deleteData,HttpSession session){
        Integer userid=sessionService.getSellerSession(session);
        if(userid==null)return new Response(503,"未登录");
        if(!sellerService.CheckProduct(deleteData.productid,userid))
            return new Response(404,"该商品不存在");
        if (!sellerService.deleteProductById(deleteData.productid))
            return new Response(500,"网络错误");
        return new Response(200,"ok");
    }
    @GetMapping("/order/get")
    public Response get(HttpSession session) {
        Integer userid = sessionService.getSellerSession(session);
        if (userid == null) return new Response(503, "未登录");
        List<OrderForShop>orderForShopList=sellerService.getOrder(userid);
        return new Response(200,orderForShopList,"ok");
    }
    @PostMapping("/update")
    public Response update(@RequestBody Products products,HttpSession session){
        Integer userid = sessionService.getSellerSession(session);
        if (userid == null) return new Response(503, "未登录");
        if(!sellerService.update(userid,products))return new Response(404,"找不到该商品");
        return new Response(200,"ok");
    }
    @PostMapping("/num/update")
    public Response updateNum(@RequestParam("number")Integer number,@RequestParam("productid")Integer productId,HttpSession session){
        Integer userid = sessionService.getSellerSession(session);
        if (userid == null) return new Response(503, "未登录");
        if(!sellerService.CheckProduct(productId,userid))return new Response(404,"找不到该商品");
        if(!sellerService.updateNumber(number,productId))return new Response(403,"数量错误");
        return new Response(200,"ok");
    }
//    @PostMapping("/upload")
//    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
//        String fileName = file.getOriginalFilename();  //获取文件原名
//        String visibleUri="/"+fileName;     //拼接访问图片的地址
//        String saveUri=uploadPath+"/"+fileName;        //拼接保存图片的真实地址
//        File saveFile = new File(saveUri);
//        //判断是否存在文件夹，不存在就创建，但其实可以直接手动确定创建好，这样不用每次保存都检测
//        if (!saveFile.exists()){
//            saveFile.mkdirs();
//        }
//        try {
//            file.transferTo(saveFile);  //保存文件到真实存储路径下
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return visibleUri;
//    }
}
