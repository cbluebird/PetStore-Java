package com.petstore.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("orders")
public class Orders {
    private Integer id;
    private Integer userid;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifydate;
    private Integer status;
    private Double amount;
    private String addr;
    private String city;
    private String country;
    private String phone;
    private String name;

    public Orders( Integer userid , Double amount, String addr, String city, String country, String phone,String name) {
        this.userid = userid;
        this.modifydate = new Date();
        this.status = 0;
        this.amount = amount;
        this.addr = addr;
        this.city = city;
        this.country = country;
        this.phone = phone;
        this.name=name;
    }
    public Orders(){}
}
