package com.petstore.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.petstore.controller.response.Image;
import com.petstore.domain.Images;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ImagesDao extends BaseMapper<Images> {
    @Select("select * from images where file=#{file}")
    Images getImage(String file);
    @Select("select * from images where productid=#{productid}")
    List<Images> getProductImages(Integer imageid);
    @Delete("delete from images where id=#{imageid}&&userid=#{userid}")
    void deleteImage(Integer imageid,Integer userid);
    @Select("select file from images where userid=#{userid}&&productid=0")
    String getPortrait(Integer userid);
    @Update("update images set file=#{file} where userid=#{userid}&&productid=0")
    void updatePortrait(String file,Integer userid);
}
