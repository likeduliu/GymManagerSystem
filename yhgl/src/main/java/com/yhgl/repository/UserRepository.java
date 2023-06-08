package com.yhgl.repository;

import com.yhgl.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

//    通过ID查找用户
    User findByUserID(String userId);

    void deleteByUserID(String userID);

    @Select("Select * from field")
    List<User> findAll();

//    @Query("select User from User where (:userid is null or User.userID=:userid)And(:name is null or User.Name=:name)And(:departmentID is null or User.DepartmentID=:departmentID)" +
//            "And(:id is null or User.ID=:id)")
//    List<User> findUserBy(@Param("userid") String userid, @Param("name") String name, @Param("departmentID")Integer departmentID, @Param("id")String id);
    @Query("SELECT u FROM User u WHERE (:userid IS NULL OR u.userID = :userid) AND (:name IS NULL OR u.Name = :name) AND (:departmentID IS NULL OR u.DepartmentID = :departmentID) AND (:id IS NULL OR u.ID = :id)")
    List<User> findUserBy(@Param("userid") String userid, @Param("name") String name, @Param("departmentID") Integer departmentID, @Param("id") String id);


//    @Update("UPDATE User SET userID=#{userID},Password = #{Password},Name=#{Name},ID=#{ID},DepartmentID={DepartmentID},RoleID=#{RoleID},Phone=#{Phone},Address=#{Address} WHERE userID = #{userID};")
//    void Update(User user);
}
