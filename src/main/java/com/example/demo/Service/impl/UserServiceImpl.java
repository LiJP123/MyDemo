package com.example.demo.Service.impl;

import com.example.demo.Service.UserService;
import com.example.demo.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jws.WebService;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebService(targetNamespace = "http://service.demo.paybay.cn/", endpointInterface = "com.example.demo.Service.UserService")
public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private Map<String, UserDTO> userMap = new HashMap<String, UserDTO>();

    public UserServiceImpl() {
        logger.info("向实体类插入数据");
        UserDTO user = new UserDTO();
        user.setUserId("411001");
        user.setUsername("zhansan");
        user.setAge("20");
        user.setUpdateTime(new Date());
        userMap.put(user.getUserId(), user);

        user = new UserDTO();
        user.setUserId("411002");
        user.setUsername("lisi");
        user.setAge("30");
        user.setUpdateTime(new Date());
        userMap.put(user.getUserId(), user);

        user = new UserDTO();
        user.setUserId("411003");
        user.setUsername("wangwu");
        user.setAge("40");
        user.setUpdateTime(new Date());
        userMap.put(user.getUserId(), user);
    }

    @Override
    public String getName(String userId) {
        return "liyd-" + userId;
    }

    @Override
    public UserDTO getUser(String userId) {
        logger.info("userMap是 {}:"+userMap);
        return userMap.get(userId);
    }
}
