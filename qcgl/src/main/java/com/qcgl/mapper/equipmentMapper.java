package com.qcgl.mapper;

import com.qcgl.pojo.equipment;
import com.qcgl.pojo.equipmentbook;
import com.qcgl.pojo.equipmentrecover;
import com.qcgl.pojo.equipmentrepair;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface equipmentMapper {


    //查询全部器材
    @Select("Select * from equipment")
    List<equipment> findAll();
    //查询器材收费标准
    @Select("Select * from equipment where equipmentid=#{equipmentid}")
    List<equipment> QueryRate(Integer equipmentid);

    //查询租用的器材
    @Select("Select * from equipmentbook where UserID=#{userID}")
    List<equipmentbook> QueryBook(String userID);


    //查询全部要返还的器材
    @Select("Select * from equipmentbook ")
    List<equipmentbook> QueryRecover();
    //已归还器材删除租用记录
    @Delete("Delete from equipmentbook where bookid=#{bookid} ")
    public void Delbook(Integer bookid);

    //查询全部维修的器材
    @Select("Select * from equipmentrepair")
    List<equipmentrepair> QueryRepair();
    //添加器材
    @Insert("INSERT INTO `equipment` (`equipmentname`, `amount`,`rate`,`state`) VALUES (#{equipmentname}, #{amount},#{rate}, #{state});")
    public void Addequipment(equipment equipment);
    //租用器材
    @Insert("INSERT INTO `equipmentbook` (`equipmentid`, `bookusername`,`bookamount`,`bookstarttime`,`bookendtime`,`UserID`) VALUES (#{equipmentid}, #{bookusername},#{bookamount}, #{bookstarttime},#{bookendtime},#{UserID});")
    public void Bookequipment(equipmentbook equipmentbook);


    //返还器材
    @Insert("INSERT INTO `equipmentrecover` (`equipmentid`, `recoverusername`,`recoveramount`) VALUES (#{equipmentid}, #{recoverusername},#{recoveramount});")
    public void Recoverequipment(equipmentrecover equipmentrecover);
    //维修器材
    @Insert("INSERT INTO `equipmentrepair` (`equipmentid`, `repairamount`) VALUES (#{equipmentid}, #{repairamount});")
    public void Repairequipment(equipmentrepair equipmentrepair);
    //删除并更新
    @Delete("Delete from equipment where equipmentid=#{equipmentid} ")
    public void Delequipment(Integer equipmentid);
    @Update("ALTER TABLE equipment AUTO_INCREMENT = #{equipmentid}")
    public void Updateequipment(Integer equipmentid);












}
