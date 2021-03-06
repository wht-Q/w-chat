package com.example.chat.infrastructure.userinfo.converter;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.chat.infrastructure.userinfo.dos.UserInfoDO;
import com.example.chat.userinfo.bo.UserInfoBO;

@Mapper
public interface UserInfoConverter {
    UserInfoConverter INSTANCE = Mappers.getMapper(UserInfoConverter.class);
    UserInfoBO toBO(UserInfoDO userInfoDO);
    UserInfoDO toDO(UserInfoBO userInfoBO);
}
