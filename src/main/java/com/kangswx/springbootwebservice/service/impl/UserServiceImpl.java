package com.kangswx.springbootwebservice.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.kangswx.springbootwebservice.entity.User;
import com.kangswx.springbootwebservice.service.UserService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;

@WebService(serviceName = "UserService",
        targetNamespace = "http://service.springbootwebservice.kangswx.com",
        endpointInterface = "com.kangswx.springbootwebservice.service.UserService")
@Component
public class UserServiceImpl implements UserService {

    private Map<Integer, User> userMap = new HashMap<>();

    public UserServiceImpl(){
        System.out.println("初始化userMap");
        User user = new User();
        user.setId(1);
        user.setName("张三");
        user.setEmail("zhangsan@test.com");
        userMap.put(user.getId(), user);

        User user1 = new User();
        user1.setId(2);
        user1.setName("李四");
        user1.setEmail("lisi@test.com");
        userMap.put(user1.getId(), user1);

        User user2 = new User();
        user2.setId(3);
        user2.setName("王五");
        user2.setEmail("wangwu@test.com");
        userMap.put(user2.getId(), user2);

    }

    @Override
    public String getUser(int id) {
        return JSONObject.toJSONString(userMap.get(id));
    }

    @Override
    public String getUserName(int id) {
        System.out.println("getUserName: "+id);
        return userMap.get(id).getName();
    }

}
