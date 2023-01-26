package com.petstore.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("ordersdetails")
public class OrdersDetails {
    private Integer orderid;
    private Integer productid;
    private Integer number;
    private Double unitcost;
    private Integer shopid;

    public OrdersDetails(Integer orderid, Integer productid, Integer number, Double unitcost, Integer shopid) {
        this.orderid = orderid;
        this.productid = productid;
        this.number = number;
        this.unitcost = unitcost;
        this.shopid = shopid;
    }
}
