package com.petstore.controller;

import com.petstore.controller.receiver.userReceiver.LoginData;
import com.petstore.controller.receiver.userReceiver.RePassData;
import com.petstore.controller.response.Response;
import com.petstore.domain.User;
import com.petstore.service.ImagesService;
import com.petstore.service.SessionService;
import com.petstore.service.UserService;
import com.petstore.utility.Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SessionService sessionService;
    @Autowired
    private ImagesService imagesService;

    @PostMapping("/login")
    public Response login(HttpSession session, @RequestBody LoginData loginData){
        Integer code=0;
        code=userService.loginByAccountAndPass(loginData.phone, loginData.password);
        if (code==0)return new Response(500,"Internal server error");
        else if(code==404){
            return new Response(404,"用户不存在");
        }
        else if (code==403){
            return new Response(403,"密码错误");
        }
        else {
            User user=userService.getUserByAccount(loginData.phone);
            sessionService.setUserSession(session,user.getId());
            user.setPassword(null);
            return new Response(200,user,"ok");
        }
    }
    @PostMapping("/register")
    public Response register(@RequestBody User user){
        System.out.println(user);
        Integer code=0;
        code=userService.getUseridByAccount(user.getPhone());
        if(code!=0)return new Response(403,"手机号码已存在");
        code=userService.register(user);
        if(code==500)return new Response(500,"网络错误");
        Integer userId=userService.getUseridByAccount(user.getPhone());
        if(!imagesService.createPortrait(userId))return new Response(500,"网络错误");
        return new Response(200,"ok");
    }
    @PostMapping("/repass")
    public Response repass(@RequestBody RePassData rePassData){
        Integer code =0;
        code=userService.getUseridByAccount(rePassData.phone);
        if(code==0)return new Response(404,"用户不存在");
        userService.updateUserByUserID(code,rePassData.password);
        return new Response(200,"ok");
    }
    @PostMapping("/user/update")
    public Response update(@RequestBody User user, HttpSession session){
        Integer userid=sessionService.getUserSession(session);
        if(userid==null)return new Response(503,"未登录");
        User user1=userService.updateUser(user,userid);
        user1.setPassword(null);
        return new Response(200,user1,"ok");
    }
}
