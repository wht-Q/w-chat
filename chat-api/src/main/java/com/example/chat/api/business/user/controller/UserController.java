package com.example.chat.api.business.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chat.api.business.user.converter.UserInfoDtoConverter;
import com.example.chat.common.exceptions.Response;
import com.example.chat.userinfo.service.UserInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/users")
@Api(tags = "UserController", description = "用户相关")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation("获取当前用户基本信息")
    @GetMapping("/detail/by/{username}")
    public Response detail(@PathVariable String username) {
        return Response.ok(UserInfoDtoConverter.INSTANCE.toDTO(userInfoService.findByUsername(username)));
    }
}