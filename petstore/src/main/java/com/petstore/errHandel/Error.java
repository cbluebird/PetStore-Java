package com.petstore.errHandel;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class Error {
    Map<Integer,String>errorMap;

    public Error() {
        Map<Integer,String> map=new HashMap<>();
        map.put(200,"ok");
        map.put(500,"系统异常，请稍后重试!");
        map.put(503,"未登录");
        this.errorMap=map;
    }
}
