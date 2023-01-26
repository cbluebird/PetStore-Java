package com.petstore.service.impl;

import com.petstore.dao.UserDao;
import com.petstore.domain.User;
import com.petstore.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
@Service
public class SessionServiceImpl implements SessionService {
    @Autowired
    private UserDao userDao;
    @Override
    public Integer setUserSession(HttpSession session,Integer userid) {
        session.setAttribute("id",userid);
        session.setMaxInactiveInterval(30*60);
        return 200;
    }

    @Override
    public Integer getUserSession(HttpSession session) {
        Integer userid= (Integer) session.getAttribute("id");
        if(userid==null)return null;
        User user=userDao.selectById(userid);
        if(user!=null)return userid;
        else{
            session.removeAttribute("id");
            return null;
        }
    }
    @Override
    public Integer getSellerSession(HttpSession session){
        Integer userid= (Integer) session.getAttribute("id");
        if(userid==null)return null;
        User user=userDao.selectById(userid);
        if((user!=null)&&user.getVersion()==1)return userid;
        else{
            session.removeAttribute("id");
            return null;
        }
    }

    @Override
    public Integer getAdminSession(HttpSession session) {
        Integer userid= (Integer) session.getAttribute("id");
        if(userid==null)return null;
        User user=userDao.selectById(userid);
        if((user!=null)&&user.getVersion()==2)return userid;
        else{
            session.removeAttribute("id");
            return null;
        }
    }
}
