package com.yhgl.controller;

import com.yhgl.pojo.user;
import com.yhgl.service.userService;
import com.yhgl.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/login")
public class userController {
    @Resource
    private userService userservice;

    @PostMapping("/login")
    public Result<user> loginController(@RequestParam String UserID,@RequestParam String Password){
        user user = userservice.loginService(UserID,Password);
        if(user!= null){
            return Result.success(user,"Login success");
        }else{
            return Result.error("123","Error!");
        }
    }
}
