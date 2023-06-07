package com.yhgl.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.yhgl.Result.ResultEnum;
import com.yhgl.Result.ResultVO;
import com.yhgl.Result.ResultVOUtil;
import com.yhgl.entity.User;
import com.yhgl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User login(String userID, String password) {
        User user = userRepository.findByUserID(userID);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        System.out.println(userID);
        return null;
    }

    public User findUser(String userID){
        User user = userRepository.findByUserID(userID);
        return user;
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User InitUser(User user) {
        if(findUser(user.getUserID())==null){
            userRepository.save(user);
            return user;
        }else{
            return user=new User();
        }
    }

    public ResultVO ChangePassword(String userid,String password,String newpw) {
        User u = userRepository.findByUserID(userid);

        System.out.println(password);
        System.out.println(u.getPassword());
        if(!u.getPassword().equals(password)){
            System.out.println("错误");
            return ResultVOUtil.error(ResultEnum.Change_FAIL);
        }else{
            u.setPassword(newpw);
            System.out.println(u);
            userRepository.save(u);
            return ResultVOUtil.success();
        }
    }

    public List<User> findUserBy(String userid,String name,Integer departmentID,String id) {
        System.out.println(userRepository.findUserBy(userid,name,departmentID,id));
        return userRepository.findUserBy(userid,name,departmentID,id);
    }
}
