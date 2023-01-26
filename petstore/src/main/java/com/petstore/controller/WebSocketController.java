package com.petstore.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Component
@ServerEndpoint("/api/websocket/{username}")//链接的地址：ws://127.0.0.1:8080/websocket/username
public class WebSocketController {

    /**
     * 在线人数
     */
    public static volatile AtomicInteger onlineNumber = new AtomicInteger(0);

    /**
     * 以用户的姓名为key，WebSocket为对象保存起来
     */
    private static Map<String, WebSocketController> clients = new ConcurrentHashMap<>();

    /**
     * 会话
     */
    private Session session;

    /**
     * 用户名称
     */
    private String username;


    /**
     * second设置为静态的 公用一个消息
     * map ConcurrentMap为线程安全的map  HashMap不安全
     */
    private static ConcurrentMap<String, Map<String, List<Object>>> messageMap = new ConcurrentHashMap<>();

    /**
     * 建立连接
     *
     * @param session
     */
    @OnOpen
    public void onOpen(@PathParam("username") String username, Session session) {
        System.out.println(this);
        onlineNumber.addAndGet(1);
//        log.info("现在来连接的客户id：" + session.getId() + "用户名：" + username);
        this.username = username;
        this.session = session;
//        log.info("有新连接加入！ 当前在线人数" + onlineNumber);
        try {
            //messageType 1代表上线 2代表下线 3代表在线名单 4代表普通消息
            //first 先给所有人发送通知，说我上线了
            Map<String, Object> map1 = Maps.newHashMap();
            map1.put("messageType", 1);
            map1.put("username", username);
            sendMessageAll(JSON.toJSONString(map1), username);
            //second 把自己的信息加入到map当中去
            clients.put(username, this);
            //third 给自己发一条消息：告诉自己现在都有谁在线
            Map<String, Object> map2 = Maps.newHashMap();
            map2.put("messageType", 3);
            //four 移除掉自己
            Set<String> set = clients.keySet();
            map2.put("onlineUsers", set);
            sendMessageTo(JSON.toJSONString(map2), username);
        } catch (IOException e) {
//            log.info(username + "上线的时候通知所有人发生了错误");
        }
        if (messageMap.get(username) != null) {
            //first 说明在用户没有登录的时候有人给用户发送消息
            //second 该用户所有未收的消息
            Map<String, List<Object>> lists = messageMap.get(username);
//            log.info(username + "离线时有人发信息");
            //third 对象用户发送的离线消息
            Iterator iteratorGet = lists.keySet().iterator();
            while (iteratorGet.hasNext()) {
                String keys = (String) iteratorGet.next();//键
                List<Object> list = lists.get(keys);
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        //four 封装消息类型   消息内容+"["+发送消息的人+";"+接收消息的人","+0
                        JSONObject rs = new JSONObject();
                        rs.put("message", list.get(i));
                        rs.put("from", keys);
                        rs.put("to", username);
                        //String message=list.get(i)+"["+keys+";"+username+","+0;
                        onMessage(rs.toString(), session);
                    }
                }
                iteratorGet.remove();
            }
//            log.info(username + "离线信息接收成功");
            // map中key（键）的迭代器对象
            //five 用户接收完消息后删除 避免下次继续发送
//            Iterator iterator = lists.keySet().iterator();
//            while (iteratorGet.hasNext()) {// 循环取键值进行判断
//                String keys = (String) iterator.next();//键
//                iteratorGet.remove(); // 移除map中以a字符开头的键对应的键值对
//                messageMap.remove(keys);
//            }

        }

    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.info("服务端发生了错误" + error.getMessage());
        //error.printStackTrace();
    }

    /**
     * 连接关闭
     */
    @OnClose
    public void onClose() {
        onlineNumber.addAndGet(-1);
        //webSockets.remove(this);
        clients.remove(username);
        try {
            //messageType 1代表上线 2代表下线 3代表在线名单  4代表普通消息
            Map<String, Object> map1 = Maps.newHashMap();
            map1.put("messageType", 2);
            map1.put("onlineUsers", clients.keySet());
            map1.put("username", username);
            sendMessageAll(JSON.toJSONString(map1), username);
        } catch (IOException e) {
            log.info(username + "下线的时候通知所有人发生了错误");
        }
//        log.info("有连接关闭！ 当前在线人数" + onlineNumber);
    }

    /**
     * 收到客户端的消息
     *
     * @param message 消息
     * @param session 会话
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        try {
//            log.info("来自客户端消息：" + message + "客户端的id是：" + session.getId());
            JSONObject jsonObject = JSON.parseObject(message);
            String textMessage = jsonObject.getString("message");
            String fromusername = jsonObject.getString("from");
            String tousername = jsonObject.getString("to");
//            log.info("用户" + fromusername + "对用户" + tousername + "说：" + textMessage);
            //messageType 1代表上线 2代表下线 3代表在线名单  4代表普通消息
            Map<String, Object> map1 = Maps.newHashMap();
            map1.put("messageType", 4);
            map1.put("textMessage", textMessage);
            map1.put("fromusername", fromusername);
            if (tousername.equals("All")) {
                map1.put("tousername", "所有人");
                sendMessageAll(JSON.toJSONString(map1), fromusername);
            } else if (clients.get(tousername) != null) {
                map1.put("tousername", tousername);
                sendMessageTo(JSON.toJSONString(map1), tousername);
            } else if (clients.get(tousername) == null) {
                saveMessage(tousername, fromusername, textMessage);
//                System.out.println("信息已保存到数据库");
                return;
            }
        } catch (Exception e) {
            log.info("发生了错误了");
        }
    }

    public void sendMessageTo(String message, String ToUserName) throws IOException {
        WebSocketController webSocket = clients.get(ToUserName);
        webSocket.session.getBasicRemote().sendText(message);
    }

    public void sendMessageAll(String message, String FromUserName) throws IOException {
        for (WebSocketController item : clients.values()) {
            item.session.getAsyncRemote().sendText(message);
        }
    }

    public static synchronized AtomicInteger getOnlineCount() {
        return onlineNumber;
    }

    public void saveMessage(String tousername, String fromusername, String message) {
        if (messageMap.get(tousername) == null) {
            //firs 用户不在线时 第一次给他发消息
            Map<String, List<Object>> maps = new HashMap<>();//该用户的所有消息
            List<Object> list = new ArrayList<>();//该用户发的离线消息的集合
            list.add(message);
            maps.put(fromusername, list);
            messageMap.put(tousername, maps);
        } else {
            //first 不在线再次发送消息
            //second 给用户的所有消息
            Map<String, List<Object>> listObject = messageMap.get(tousername);
            List<Object> objects = new ArrayList<>();
            if (listObject.get(fromusername) != null) {//first 这个用户给收消息的这个用户发过消息
                //second此用户给该用户发送过离线消息（此用户给该用户发过的所有消息）
                objects = listObject.get(fromusername);
                objects.add(message);//加上这次发送的消息
                //maps.put(sendUserId, objects);
                //替换原来的map
                listObject.put(fromusername, objects);
            } else {//third 这个用户没给该用户发送过离线消息
                objects.add(message);
                listObject.put(fromusername, objects);
            }
        }
    }
}


//package com.petstore.controller;
//
//
//import com.petstore.service.WebSocket;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.IOException;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/webSocket")
//public class WebSocketController {
//    @Autowired
//    private WebSocket webSocket;
//    @PostMapping("/sentMessage")
//    public void sentMessage(String userId,String message){
//        try {
//            webSocket.sendMessageByUserId(userId,message);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//}

