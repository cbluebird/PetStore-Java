package com.petstore.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User {
    private Integer id;
    private String password;
    private String email;
    private String name;
    private String addr;
    private String city;
    private String country;
    private String phone;
    private Integer version;
}
