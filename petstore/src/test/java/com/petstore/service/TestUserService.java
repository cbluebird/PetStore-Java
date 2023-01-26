package com.petstore.service;

import com.petstore.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestUserService {
    @Autowired
    private UserService userService;
    @Test
    void login(){
        String account ="13989790296";
        String password ="1234567";
        Integer code=userService.loginByAccountAndPass(account,password);
        System.out.println(code);
    }
    @Test
    void register(){
        User user=new User();
        user.setName("陈王彬");
        user.setAddr("浙江");
        user.setCountry("中国");
        user.setPassword("1234567");
        user.setEmail("cwb@163.com");
        user.setPhone("13989790296");
        user.setCity("宁波");
        userService.register(user);
    }
    @Test
    void update(){
        User user=new User();
        user.setName(null);
        user.setCountry("美国");
        userService.updateUser(user,8);
    }
}
