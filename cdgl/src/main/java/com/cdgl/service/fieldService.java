package com.cdgl.service;

import com.cdgl.pojo.field;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface fieldService {


    
    @Select("SELECT * from field")
    List<field> findAll();
    @Select("Select *from field where book='2' ")
    List<field> unbook();
    @Select("Select *from field where book='1'")
    List<field> booked();

    @Delete("Delete * from field where fieldid=#{fieldid}")
    String DelField();
    @Update("ALTER TABLE field AUTO_INCREMENT = #{fieldid}")
    void UpdateFieldId(Integer fieldid);
    @Insert("INSERT INTO `field` (`fieldName`, `kind`) VALUES (#{fieldName}, #{kind}, #{book});")
    void AddField();
    @Update("UPDATE field SET book = 1,bookusername=#{bookusername},bookstarttime=#{bookstarttime},bookendtime=#{bookendtime} WHERE fieldid = #{fieldid};")
    public void BookField(field field);
    @Update("UPDATE field SET book=2 WHERE fieldid=#{fieldid}")
    public void CancleBook(Integer fieldid);
}
