package com.petstore.controller;

import com.petstore.controller.response.Response;
import com.petstore.domain.Products;
import com.petstore.service.SessionService;
import com.petstore.service.UniversalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UniversalController {
    @Autowired
    private SessionService sessionService;
    @Autowired
    private UniversalService universalService;
    @GetMapping("/getall")
    public Response getAll(@RequestParam("page") Integer page){
        Integer pages=(page-1)*10;
        List<Products> a = universalService.getAll(pages);
        return new Response(200,a,"ok");
    }
    @GetMapping("/getstore")
    public Response getShop(@RequestParam("page") Integer page, @RequestParam("stroeid")Integer shopId){
        Integer pages=(page-1)*10;
        List<Products> a = universalService.getShopProducts(shopId,pages);
        return new Response(200,a,"ok");
    }
    @GetMapping("/getcategory")
    public Response getCategory(){
        List<String> a=universalService.getCategory();
        return new Response(200,a,"ok");
    }
    @GetMapping("/category/getproduct")
    public Response getCategoryProduct(@RequestParam("page") Integer page, @RequestParam("category")String category
                                       ){
        Integer pages=(page-1)*10;
        List<Products> a =universalService.getCategoryProduct(category,pages);
        return new Response(200,a,"ok");
    }
    @GetMapping("/catrgory/shop/getproducts")
    public Response getShopCategoryProduct(@RequestParam("page") Integer page, @RequestParam("category")String category,
                                       @RequestParam("shopid")Integer shopId) {
        Integer pages = (page - 1) * 10;
        List<Products> a = universalService.getShopCategoryProduct(category,pages,shopId);
        return new Response(200, a, "ok");
    }
    @GetMapping("/getone")
    public Response get(@RequestParam("productid")Integer productId){
        Products products=universalService.getProduct(productId);
        return new Response(200,products,"ok");
    }
}
