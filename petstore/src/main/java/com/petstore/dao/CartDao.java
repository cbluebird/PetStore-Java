package com.petstore.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.petstore.domain.Cart;
import lombok.Data;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CartDao extends BaseMapper<Cart> {
    @Select("select * from cart where userid=#{userid}&&productid=#{productid}")
    Cart getCartByUseridAndProductId(Integer userid,Integer productid);
    @Update("update cart set unitcost=#{price},number=#{number} where userid=#{userid}&&productid=#{productid}")
    void updateCart(Integer number,Double price,Integer userid,Integer productid);
    @Delete("delete from cart where userid=#{userid}&&productid=#{productid}")
    void deleteCart(Integer userid,Integer productid);
    @Select("select * from cart where userid=#{userid}")
    List<Cart> getCart(Integer userid);
}
