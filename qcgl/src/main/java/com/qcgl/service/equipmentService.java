package com.qcgl.service;


import com.qcgl.pojo.equipment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface equipmentService {


    //查全部器材
    @Select("SELECT * from equipment")
    List<equipment> findAll();
//    @Select("Select *from field where book='2' ")
//    List<field> unbook();
//    @Select("Select *from field where book='1'")
//    List<field> booked();
      //删除并更新器材
      @Delete("Delete * from equipment where equipmentid=#{equipmentid}")
      void Delequipment();
      @Update("ALTER TABLE equipment AUTO_INCREMENT = #{equipmentid}")
      void Updateequipment(Integer equipmentid);
      //添加器材
      @Insert("INSERT INTO `equipment` (`equipmentname`, `amount`,`state`) VALUES (#{equipmentname}, #{amount}, #{state});")
      void Addequipment();
//    @Update("UPDATE field SET book = 1,bookusername=#{bookusername},bookstarttime=#{bookstarttime},bookendtime=#{bookendtime} WHERE fieldid = #{fieldid};")
//    public void BookField(field field);
//    @Update("UPDATE field SET book=2 WHERE fieldid=#{fieldid}")
//    public void CancleBook(Integer fieldid);
}
