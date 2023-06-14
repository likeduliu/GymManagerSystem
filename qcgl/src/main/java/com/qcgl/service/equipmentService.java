package com.qcgl.service;


import com.qcgl.pojo.equipment;
import com.qcgl.pojo.equipmentbook;
import com.qcgl.pojo.equipmentrecover;
import com.qcgl.pojo.equipmentrepair;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface equipmentService {


    //查全部器材
    @Select("SELECT * from equipment")
    List<equipment> findAll();
    //查器材收费标准
    @Select("SELECT * from equipment where equipmentid=#{equipmentid}")
    List<equipment> QueryRate(Integer equipmentid);
    //查租用的器材
    @Select("SELECT * from equipmentbook where UserID=#{userID}")
    List<equipmentbook> QueryBook(String userID);

    //查询全部租用的器材
    @Select("SELECT * from equipmentbook ")
    List<equipmentbook> QueryRecover();
    //已归还器材删除租用记录
    @Delete("Delete from equipmentbook where bookid=#{bookid} ")
     void Delbook();

    //查询全部维修的器材
    @Select("Select * from equipmentrepair")
    List<equipmentrepair> QueryRepair();
      //删除并更新器材
      @Delete("Delete * from equipment where equipmentid=#{equipmentid}")
      void Delequipment();
      @Update("ALTER TABLE equipment AUTO_INCREMENT = #{equipmentid}")
      void Updateequipment(Integer equipmentid);
      //添加器材
      @Insert("INSERT INTO `equipment` (`equipmentname`, `amount`,`rate`,`state`) VALUES (#{equipmentname}, #{amount},#{rate}, #{state});")
      void Addequipment();
     //租用器材
      @Insert("INSERT INTO `equipmentbook` (`equipmentid`, `bookusername`,`bookamount`,`bookstarttime`,`bookendtime`,`UserID`) VALUES (#{equipmentid}, #{bookusername},#{bookamount}, #{bookstarttime},#{bookendtime},#{UserID});")
      void Bookequipment();

      //返还器材
      @Insert("INSERT INTO `equipmentrecover` (`equipmentid`, `recoverusername`,`recoveramount`) VALUES (#{equipmentid}, #{recoverusername},#{recoveramount});")
       void Recoverequipment();
      //维修器材
      @Insert("INSERT INTO `equipmentrepair` (`equipmentid`, `repairamount`) VALUES (#{equipmentid}, #{repairamount});")
      void Repairequipment();

}
