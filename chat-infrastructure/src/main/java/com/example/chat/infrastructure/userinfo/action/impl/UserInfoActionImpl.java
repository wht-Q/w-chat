package com.example.chat.infrastructure.userinfo.action.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.chat.infrastructure.userinfo.action.UserInfoAction;
import com.example.chat.infrastructure.userinfo.dos.UserInfoDO;
import com.example.chat.infrastructure.userinfo.mapper.UserInfoMapper;


@Service
public class UserInfoActionImpl extends ServiceImpl<UserInfoMapper, UserInfoDO> implements UserInfoAction {
}
