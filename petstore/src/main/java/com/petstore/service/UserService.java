package com.petstore.service;

import com.petstore.domain.User;

import javax.servlet.http.HttpSession;

public interface UserService {
    Integer register(User user);
    Integer loginByAccountAndPass(String account, String password);
    Integer getUseridByAccount(String account);

    void updateUserByUserID(Integer userid,String password);
    User getUserByAccount(String account);
    String getUserNameByUserid(Integer userid);
    User updateUser(User user,Integer userid);
}
