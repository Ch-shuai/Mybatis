package com.example.demo.entity.vo;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * 登陆时的VO对象，由前段传递
 */
public class LoginVo {

    @NotBlank(message = "登陆名称不能为空")
    @ApiModelProperty(name = "username",value = "姓名")
    public String username;

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(name = "password",value = "密码")
    private String password;

    @NotBlank(message = "验证码不能为空")
    @ApiModelProperty(name = "checkcode",value = "验证码")
    private String checkcode;

    @NotBlank(message = "随机时间戳,用于校验验证码")
    @ApiModelProperty(name = "randTime",value = "随机时间戳")
    private String randTime;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getCheckcode() {
        return checkcode;
    }

    public void setCheckcode(String checkcode) {
        this.checkcode = checkcode;
    }

    public String getRandTime() {
        return randTime;
    }

    public void setRandTime(String randTime) {
        this.randTime = randTime;
    }
}
