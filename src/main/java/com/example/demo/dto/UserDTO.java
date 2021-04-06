package com.example.demo.dto;

import java.io.Serializable;
import java.util.Date;

public class UserDTO implements Serializable {

    private static final long serialVersionUID=1L;;
    private String userId;
    private String username;
    private String age;
    private Date updateTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", age='" + age + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
