package com.example.chat.userinfo.manager;

import com.example.chat.userinfo.bo.UserInfoBO;

public interface UserInfoManager {

    UserInfoBO findByUsername(String username);

    UserInfoBO findByUserId(String userId);

    Boolean disable(String userId);

    Boolean add(UserInfoBO user);
}
