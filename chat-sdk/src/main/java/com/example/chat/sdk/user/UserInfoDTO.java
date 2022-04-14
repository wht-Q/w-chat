package com.example.chat.sdk.user;

import java.io.Serializable;
import java.time.LocalDateTime;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)//链式访问
@ApiModel(value = "UserInfo对象", description = "")
public class UserInfoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

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

