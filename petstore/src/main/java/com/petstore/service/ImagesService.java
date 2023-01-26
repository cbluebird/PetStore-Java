package com.petstore.service;

import com.petstore.controller.response.Image;
import com.petstore.domain.Images;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImagesService {
    String saveImage(MultipartFile file, Integer userId);
    Boolean CreateImage(String file,Integer userid,Integer productId);
    Boolean createPortrait(Integer userid);
    List<Images> getProductImages(Integer productId);
    void deleteImage(Integer imageId,Integer userId);
    Boolean deleteLocal(String fileUrl);
    String getPortrait(Integer userId);
    String updateLocal(Integer userId,MultipartFile file,String url);
    void updatePortrait(String url,Integer userid);
    void updateImage(String image,Integer productId);

}
