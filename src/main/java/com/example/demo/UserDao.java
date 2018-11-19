package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class UserDao {

    private String userName;
    private String userPsw;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPsw() {
        return userPsw;
    }

    public void setUserPsw(String userPsw) {
        this.userPsw = userPsw;
    }

    public UserDao() {
    }
}
