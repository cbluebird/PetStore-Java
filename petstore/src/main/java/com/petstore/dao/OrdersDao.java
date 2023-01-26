package com.petstore.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.petstore.domain.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface OrdersDao extends BaseMapper<Orders> {
    @Select("select id from orders where userid=#{userid} order by modifydate desc limit 1")
    Integer getOrderId(Integer userid);
    @Select("select * from orders where userid=#{userid}&&status=0 limit #{page},10")
    List<Orders>getOrders(Integer userid,Integer page);
    @Select("select * from orders where userid=#{userid} limit #{page},10")
    List<Orders>getAllOrders(Integer userid,Integer page);
    @Update("update orders set status=1 where id=#{id}")
    void updateOrder(Integer id);
}
