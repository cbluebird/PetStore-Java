package com.petstore.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Repository;


@TableName("products")
@Data
public class Products {
    private Integer id;
    private String category;
    private String name;
    private String image;
    private String description;
    private Double price;
    private Integer version;
    private Integer status;
    private Integer number;
    private Integer shopid;

    public Products(String category, String name, String image, String description, Double price, Integer number,Integer shopid) {
        this.category = category;
        this.name = name;
        this.image = image;
        this.description = description;
        this.price = price;
        this.number = number;
        this.status=0;
        this.version=0;
        this.shopid=shopid;
    }
    public Products(String category, String name,  String description, Double price, Integer number,Integer shopid) {
        this.category = category;
        this.name = name;
        this.description = description;
        this.price = price;
        this.number = number;
        this.status=0;
        this.version=0;
        this.shopid=shopid;
    }
    public Products() {
    }
}
