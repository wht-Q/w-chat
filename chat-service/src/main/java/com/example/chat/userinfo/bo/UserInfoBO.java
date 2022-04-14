package com.example.chat.userinfo.bo;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserInfoBO {
    private Integer id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("电话	电话")
    private String phoneNumber;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("层级")
    private String rating;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
