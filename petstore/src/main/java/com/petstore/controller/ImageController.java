package com.petstore.controller;

import com.petstore.controller.response.Image;
import com.petstore.controller.response.Response;
import com.petstore.domain.Images;
import com.petstore.service.ImagesService;
import com.petstore.service.SellerService;
import com.petstore.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user/image")
public class ImageController {
    @Autowired
    private SessionService sessionService;
    @Autowired
    private ImagesService imagesService;
    @Autowired
    private SellerService sellerService;
    @PostMapping("/product/addimage")
    public Response addImage(@RequestParam(value = "file") MultipartFile file, @RequestParam(value = "productid")Integer productId,
                             HttpSession session){
        Integer userid=sessionService.getSellerSession(session);
        if(userid==null)return new Response(503,"未登录");
        if(!sellerService.CheckProduct(productId,userid))
            return new Response(404,"该商品不存在");
        String fileUrl=imagesService.saveImage(file,productId);
        if (fileUrl==null)return new Response(403,"图片已经存在");
        if(!imagesService.CreateImage(fileUrl,userid,productId))return new Response(500,"网络错误");
        return new Response(200,"ok");
    }
    @GetMapping("/product/getimage")
    public Response getimage(@RequestParam(value = "productid")Integer productId){
        List<Images> a=imagesService.getProductImages(productId);
        List<Image>r = new ArrayList<>();;
        for(int i=0;i<a.size();i++){
            Images images=a.get(i);
            r.add(new Image(images.getId(),images.getFile()));
        }
        return new Response(200,r,"ok");
    }
    @PostMapping ("/product/deleteimage")
    public Response deleteImage(@RequestParam(value = "imageid")Integer imageId,@RequestParam(value = "file")String fileUrl,
                                HttpSession session){
        Integer userid=sessionService.getSellerSession(session);
        if(userid==null)return new Response(503,"未登录");
        imagesService.deleteImage(imageId,userid);
        imagesService.deleteLocal(fileUrl);
        return new Response(200,"ok");
    }
    @GetMapping("/getimage")
    public Response get(HttpSession session){
        Integer userid=sessionService.getUserSession(session);
        if(userid==null)return new Response(503,"未登录");
        String url=imagesService.getPortrait(userid);
        return new Response(200,url,"ok");
    }
    @PostMapping("/updateimage")
    public Response update(@RequestParam(value = "file") MultipartFile file,HttpSession session){
        Integer userid=sessionService.getUserSession(session);
        if(userid==null)return new Response(503,"未登录");
        String url=imagesService.getPortrait(userid);
        String urlUpdate=imagesService.updateLocal(userid,file,url);
        imagesService.updatePortrait(urlUpdate,userid);
        return new Response(200,"ok");
    }
}
