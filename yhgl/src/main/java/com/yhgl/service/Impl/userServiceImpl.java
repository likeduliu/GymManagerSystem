package com.yhgl.service.Impl;

import com.yhgl.mapper.userMapper;
import com.yhgl.pojo.user;
import com.yhgl.service.userService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class userServiceImpl implements userService {

    @Resource
    private userMapper usermapper;
    @Override
    public user loginService(String UserID, String Password) {
        user user=usermapper.findByUserIDAndPassword(UserID,Password);
        if(user !=null){
            user.setPassword("");
        }
        return user;
    }

}
