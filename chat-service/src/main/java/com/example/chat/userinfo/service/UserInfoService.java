package com.example.chat.userinfo.service;


import com.example.chat.userinfo.bo.UserInfoBO;

public interface UserInfoService {
    UserInfoBO findByUsername(String username);
}
