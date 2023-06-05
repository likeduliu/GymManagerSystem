package com.qcgl.mapper;

import com.qcgl.pojo.equipment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface equipmentMapper {


    //查询全部器材
    @Select("Select * from equipment")
    List<equipment> findAll();

    //添加器材
    @Insert("INSERT INTO `equipment` (`equipmentname`, `amount`,`state`) VALUES (#{equipmentname}, #{amount}, #{state});")
    public void Addequipment(equipment equipment);

    //删除并更新
    @Delete("Delete from equipment where equipmentid=#{equipmentid} ")
    public void Delequipment(Integer equipmentid);

    @Update("ALTER TABLE equipment AUTO_INCREMENT = #{equipmentid}")
    public void Updateequipment(Integer equipmentid);












}
