package com.petstore.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.petstore.domain.Products;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface ProductsDao extends BaseMapper<Products> {
    @Update("update products set status=#{status} where id=#{productid}")
    void updateStatusByProductId(Integer productid, Integer status);

    @Select("select * from products where status=1 order by version desc limit #{pages},10")
    List<Products> getAllProducts(Integer pages);

    @Select("select * from products where status=1&&shopid=#{shopId} order by version desc limit #{page},10")
    List<Products> getShopProducts(Integer shopId, Integer page);

    @Select("select category from products where status=1 group by category;")
    List<String> getCategory();
    @Select("select * from products where status=1&&category=#{category} order by version desc limit #{page},10")
    List<Products> getCategoryProducts(String category, Integer page);

    @Select("select * from products where status=1&&category=#{category}&&shopid=#{shopId} order by version desc limit #{page},10")
    List<Products> getShopCategoryProducts(String category, Integer page,Integer shopId);

    @Update("update products set status=2 where id=#{productid}")
    void deleteProductById(Integer productid);
    @Select("select * from products where status=0 limit #{page},10")
    List<Products> getAllUnApproveProduct(Integer page);

    @Update("update products set version=version+#{number} where id=#{productid}&&version+#{number}<=number")
    void purchase(Integer productid,Integer number);
    @Select("select name from products where id=#{id}")
    String getNameByid(Integer id);

    @Select("select id from products where shopid=#{id} order by id desc limit 1")
    Integer getNewProduct(Integer id);
}
