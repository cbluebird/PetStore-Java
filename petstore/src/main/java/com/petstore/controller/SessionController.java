package com.petstore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/service1")
public class SessionController {
    @RequestMapping("/setmsg")
    public String setMsg(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.setAttribute("msg","hello world!");
        session.setMaxInactiveInterval(30*60);
        return "ok";
    }
    @RequestMapping("/getmsg")
    public String getMsg(HttpServletRequest request){
        HttpSession session=request.getSession();
        String msg= (String) session.getAttribute("msg");
        return msg;
    }
}
