package com.example.chat.infrastructure.userinfo.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.chat.infrastructure.userinfo.converter.UserInfoConverter;
import com.example.chat.infrastructure.userinfo.dos.UserInfoDO;
import com.example.chat.infrastructure.userinfo.mapper.UserInfoMapper;
import com.example.chat.userinfo.bo.UserInfoBO;
import com.example.chat.userinfo.manager.UserInfoManager;

@Service
public class UserInfoManagerImpl implements UserInfoManager {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfoBO findByUsername(String username) {
        LambdaQueryWrapper<UserInfoDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(UserInfoDO::getUsername, username);
        return UserInfoConverter.INSTANCE.toBO(userInfoMapper.selectOne(queryWrapper));
    }
}
