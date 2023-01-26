package com.petstore.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.petstore.controller.response.Image;
import com.petstore.dao.ImagesDao;
import com.petstore.dao.ProductsDao;
import com.petstore.domain.Images;
import com.petstore.domain.Products;
import com.petstore.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
public class ImagesServiceImpl implements ImagesService {
    @Value(("${web.upload-path}"))
    private String uploadPath;
    @Value(("${default-avatar}"))
    private String defaultAvatar;
    @Autowired
    private ImagesDao imagesDao;
    @Autowired
    private Images images;
    @Autowired
    private ProductsDao productsDao;
    @Override
    public String saveImage(MultipartFile file,Integer productId){
        String userFile=productId.toString();
        String fileName = file.getOriginalFilename();  //获取文件原名
        String visibleUri="/product/"+userFile+"/"+fileName;     //拼接访问图片的地址
        String saveUri=uploadPath+visibleUri;        //拼接保存图片的真实地址
        File saveFile = new File(saveUri);
        //判断是否存在文件夹，不存在就创建，但其实可以直接手动确定创建好，这样不用每次保存都检测
        if (!saveFile.exists()){
            saveFile.mkdirs();
        }else {
            return null;
        }
        try {
            file.transferTo(saveFile);  //保存文件到真实存储路径下
        } catch (IOException e) {
            e.printStackTrace();
        }
        return visibleUri;
    }
    @Override
    public Boolean deleteLocal(String fileUrl){
        String path=uploadPath+fileUrl;
        return FileSystemUtils.deleteRecursively(new File(path));
    }
    @Override
    public String updateLocal(Integer userId,MultipartFile file,String url){
        String userFile=userId.toString();
        String fileName = file.getOriginalFilename();  //获取文件原名
        String visibleUri="/user/"+userFile+"/"+fileName;     //拼接访问图片的地址
        String saveUri=uploadPath+visibleUri;        //拼接保存图片的真实地址
        File saveFile = new File(saveUri);
        if (!saveFile.exists()){
            saveFile.mkdirs();
        }
        //判断是否存在文件夹，不存在就创建，但其实可以直接手动确定创建好，这样不用每次保存都检测
        if(!Objects.equals(url, defaultAvatar)){
            deleteLocal(url);
        }
        try {
            file.transferTo(saveFile);  //保存文件到真实存储路径下
        } catch (IOException e) {
            e.printStackTrace();
        }
        return visibleUri;
    }
    @Override
    public Boolean CreateImage(String file,Integer userid,Integer productId){
        return imagesDao.insert(new Images(userid,productId,file))>0;
    }
    @Override
    public Boolean createPortrait(Integer userid){
        images.setProductid(0);
        images.setUserid(userid);
        return imagesDao.insert(new Images(userid,defaultAvatar))>0;
    }
    @Override
    public List<Images> getProductImages(Integer productId){
        return imagesDao.getProductImages(productId);
    }
    @Override
    public void deleteImage(Integer imageId,Integer userId){
        imagesDao.deleteImage(imageId,userId);
    }
    @Override
    public String getPortrait(Integer userId){
        return imagesDao.getPortrait(userId);
    }
    @Override
    public void updatePortrait(String url,Integer userid){
        imagesDao.updatePortrait(url,userid);
    }
    @Override
    public void updateImage(String image,Integer productId){
        Products products=new Products();
        products.setImage(image);
        products.setId(productId);
        productsDao.updateById(products);
    }
}
