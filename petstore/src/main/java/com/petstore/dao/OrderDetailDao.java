package com.petstore.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.petstore.domain.OrdersDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderDetailDao extends BaseMapper<OrdersDetails> {
    @Select("select * from ordersdetails where shopid=#{shopid}")
    List<OrdersDetails> getOrders(Integer shopid);
    @Select("select * from ordersdetails where orderid=#{id}")
    List<OrdersDetails> getOrderById(Integer id);
}
