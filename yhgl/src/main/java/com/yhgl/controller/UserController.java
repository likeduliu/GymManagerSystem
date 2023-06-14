package com.yhgl.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yhgl.Result.ResultEnum;
import com.yhgl.Result.ResultVO;
import com.yhgl.Result.ResultVOUtil;
import com.yhgl.entity.User;
import com.yhgl.repository.UserRepository;
import com.yhgl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@RestController
@CrossOrigin // 允许跨域访问
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResultVO login(@RequestBody Map<String,Object> user) {
//        System.out.println(user.get("userID"));
        String userid= (String) user.get("userID");
        String password= (String) user.get("Password");
//        System.out.println(user.get("Password"));
        User u = userService.login(userid,password);
        if (u == null) {
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }
        System.out.println(userService.findUser(userid));
        return ResultVOUtil.success(userService.findUser(userid));
    }

    @PostMapping("/InitUser")
    public ResultVO InitUser(@RequestBody Map<String,Object> user){
        System.out.println(user);
        User inituser = new User();
//        将前端传来的数据赋值给User对象并保存
        inituser.setUserID((String) user.get("userid"));
        inituser.setName((String) user.get("name"));
        inituser.setDepartmentID(Integer.parseInt((String) user.get("departermentid")));
        inituser.setRoleID(Integer.parseInt((String) user.get("roleid")));
        inituser.setID((String) user.get("id"));
        inituser.setPhone((String) user.get("phone"));
        inituser.setAddress((String) user.get("address"));
        inituser.setPassword("123456");

        User u = userService.InitUser(inituser);

        if (u != null) {
            int roleid =u.getRoleID();
            return ResultVOUtil.success('0'+roleid);
        }else {
        return ResultVOUtil.error(ResultEnum.INIT_FAIL);
        }
    }

    @RequestMapping("/SearchUser")
    public List<User> SearchUser() {
        List<User> userList = userService.findAll();
        System.out.println(userList);
        return userList;
    }

    @PostMapping("/ChangePassword")
    public ResultVO ChangePassword(@RequestBody Map<String,Object> user){
        System.out.println(user);
        String userid= (String) user.get("userid");
        String password= (String) user.get("oldpw");
        String newpw= (String) user.get("newpw");
        return userService.ChangePassword(userid,password,newpw);
    }

    @PostMapping("/SearchUserBy")
    public List<User> SearchUserBy(@RequestBody Map<String,Object> user){
        String userid= (String) user.get("userid");
        String name= (String) user.get("name");
        Integer departmentID= (Integer) user.get("departmentID");
        String id= (String) user.get("id");
        System.out.println(user);
        System.out.println();
        List<User> userList = userService.findUserBy(userid,name,departmentID,id);

//        return userService.ChangePassword(userid,password,newpw);
        return null;
    }

    @PostMapping("/ManagerRole")
    public void ManagerRole(@RequestBody Map<String,Object> user){
        String userid= (String) user.get("userid");
        Integer roleid= Integer.parseInt((String)user.get("roleid"));
        userService.ManagerRole(userid,roleid);
    }

    @PostMapping("/DeleteUser")
    public void DeleteUser(@RequestBody Map<String,Object> user){
        String userid= (String) user.get("userid");
        System.out.println(userid);
        System.out.println(user);
        userService.DeleteUser(userid);
    }

    public void test(){

    }

}

