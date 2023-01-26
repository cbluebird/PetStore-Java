package com.petstore.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("cart")
public class Cart {
    private Integer userid;
    private Integer productid;
    private Integer number;
    private Double unitcost;

    public Cart(Integer userid, Integer productid, Integer number, Double unitcost) {
        this.userid = userid;
        this.productid = productid;
        this.number = number;
        this.unitcost = unitcost;
    }

    public Cart() {
    }
}
