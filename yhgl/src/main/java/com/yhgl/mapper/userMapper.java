package com.yhgl.mapper;

import com.yhgl.pojo.user;
import com.yhgl.pojo.department;
import com.yhgl.pojo.role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface userMapper extends JpaRepository<user,String>{

//    查询条件
    @Select("select DepartmentName from department where DepartmentID=")

    user findByUserID(String UserID);
    user findByName(String Name);
    user findByID(String ID);

//    对比数据库中是否存在该用户
    user findByUserIDAndPassword(String UserID, String Password);

//    新增用户

//    删除用户

//    更改密码

//    角色管理

}

