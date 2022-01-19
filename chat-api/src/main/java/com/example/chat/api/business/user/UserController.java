package com.example.chat.api.business.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/users")
@Api(tags = "UserController", description = "用户相关")
public class UserController {

    @ApiOperation("获取当前用户基本信息")
    @GetMapping("/detail")
    public Object detail() {
        return "sss";
    }
}
