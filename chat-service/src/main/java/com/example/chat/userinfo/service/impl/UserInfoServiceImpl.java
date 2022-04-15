package com.example.chat.userinfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chat.common.exceptions.BusinessException;
import com.example.chat.common.exceptions.ResultCode;
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

    @Override
    public UserInfoBO findByUserId(String userId) {
        return userInfoManager.findByUserId(userId);
    }

    @Override
    public Boolean add(UserInfoBO user) {
        UserInfoBO byUsername = findByUsername(user.getUsername());
        if (byUsername != null) {
        throw new BusinessException(ResultCode.USER_EXISTED,user.getUsername());
        }
        return userInfoManager.add(user);
    }

    @Override
    public Boolean disable(String userId) {
        UserInfoBO byUsername = findByUserId(userId);
        if (byUsername == null) {
            throw new BusinessException(ResultCode.USER_NOT_FOUND,"编号："+userId);
        }
        return userInfoManager.disable(userId);
    }
}
