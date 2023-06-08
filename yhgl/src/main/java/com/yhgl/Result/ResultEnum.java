package com.yhgl.Result;

import lombok.Getter;

@Getter
public enum ResultEnum {
    SUCCESS(0, "登录成功！跳转至主页面"),
    LOGIN_FAIL(1, "登录失败，用户名或密码错误"),
    INIT_FAIL(2,"注册失败，已存在该学号/教职工号"),
    Change_FAIL(3,"修改失败！请重新确认密码！");;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
