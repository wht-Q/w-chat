package com.example.chat.userinfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chat.userinfo.bo.UserInfoBO;
import com.example.chat.userinfo.manager.UserInfoManager;
import com.example.chat.userinfo.service.UserInfoService;


@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoManager userInfoManager;
    @Override
    public UserInfoBO findByUsername(String username) {
        return userInfoManager.findByUsername(username);
    }
}
