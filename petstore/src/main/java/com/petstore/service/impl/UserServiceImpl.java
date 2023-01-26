package com.petstore.service.impl;

import com.petstore.dao.UserDao;
import com.petstore.domain.User;
import com.petstore.service.UserService;
import com.petstore.utility.Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private SessionServiceImpl sessionService;
    @Autowired
    private Encrypt encrypt;
    @Override
    public Integer loginByAccountAndPass(String account, String password) {
        User user=userDao.getUserByAccount(account);
        String pass=encrypt.sha256(password);
        if (user==null)return 404;
        if (user.getPassword().equals(pass)){
            return 200;
        }
        else return 403;
    }

    @Override
    public Integer register(User user) {
        String pass=encrypt.sha256(user.getPassword());
        user.setPassword(pass);
        if(userDao.insert(user)>0)return 200;
        else return 500;
    }
    @Override
    public Integer getUseridByAccount(String account){
        User user=userDao.getUserByAccount(account);
        if(user==null)return 0;
        return user.getId();
    }
    @Override
    public void updateUserByUserID(Integer userid,String password){
        String pass=encrypt.sha256(password);
        userDao.updatePasswordById(userid,pass);
    }
    @Override
    public User getUserByAccount(String account){
        User user=userDao.getUserByAccount(account);
        return user;
    }
    @Override
    public String getUserNameByUserid(Integer userid){
        User user=userDao.selectById(userid);
        return user.getName();
    }
    @Override
    public User updateUser(User user,Integer userid){
        user.setId(userid);
        userDao.updateById(user);
        return userDao.selectById(userid);
    }
}
