//package com.yhgl.service.Impl;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.yhgl.entity.User;
//import com.yhgl.mapper.UserMapper;
//import com.yhgl.req.UserLoginReq;
//import com.yhgl.service.UserService;
//import org.apache.ibatis.annotations.Select;
//import org.springframework.stereotype.Service;
//import org.springframework.util.CollectionUtils;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//@Service
//public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
//    @Resource
//    private UserMapper userMapper;
//
//
//    @Override
//    public UserLoginReq login(UserLoginReq req) {
////        User userDb = selectByUserID(req.getUserID());
//        return null;
//    }
//
////    private User selectByUserID(String userID) {
////        QueryWrapper<User> wrapper = new QueryWrapper<>();
////        wrapper.lambda().eq(User::getUserID,userID);
////        List<User> userList = userMapper.selectList(wrapper);
////        if(CollectionUtils.isEmpty(userList)){
////            return null;
////        }else{
////            return userList.get(0);
////        }
////    }
//}
