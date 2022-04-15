package com.example.chat.infrastructure.userinfo.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.chat.infrastructure.userinfo.action.impl.UserInfoActionImpl;
import com.example.chat.infrastructure.userinfo.converter.UserInfoConverter;
import com.example.chat.infrastructure.userinfo.dos.UserInfoDO;
import com.example.chat.infrastructure.userinfo.mapper.UserInfoMapper;
import com.example.chat.userinfo.bo.UserInfoBO;
import com.example.chat.userinfo.manager.UserInfoManager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserInfoManagerImpl implements UserInfoManager {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserInfoActionImpl userInfoAction;

    @Override
    public UserInfoBO findByUsername(String username) {
        LambdaQueryWrapper<UserInfoDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(UserInfoDO::getUsername, username);
        return UserInfoConverter.INSTANCE.toBO(userInfoMapper.selectOne(queryWrapper));
    }

    @Override
    public UserInfoBO findByUserId(String userId) {
        return UserInfoConverter.INSTANCE.toBO(userInfoAction.getById(Integer.valueOf(userId)));
    }

    @Override
    public Boolean disable(String userId) {
        log.info("UserInfoManagerImpl disable {}", userId);
        return userInfoAction.lambdaUpdate()
                .set(UserInfoDO::getIfActive, false)
                .eq(UserInfoDO::getId, Integer.valueOf(userId))
                .update();
    }

    @Override
    public Boolean add(UserInfoBO user) {
        return userInfoAction.save(UserInfoConverter.INSTANCE.toDO(user));
    }
}
