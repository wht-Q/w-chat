package com.example.chat.api.business.user.converter;


import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.example.chat.sdk.user.UserInfoDTO;
import com.example.chat.userinfo.bo.UserInfoBO;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserInfoDtoConverter {
    UserInfoDtoConverter INSTANCE = Mappers.getMapper(UserInfoDtoConverter.class);
    UserInfoBO toBO(UserInfoDTO userInfo);
    UserInfoDTO toDTO(UserInfoBO userInfoBO);

}
