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
    @Delete("Delete * from field where fieldid=#{fieldid}")
    String DelField();
    @Update("ALTER TABLE field AUTO_INCREMENT = #{fieldid}")
    void UpdateFieldId(Integer fieldid);
    @Insert("INSERT INTO `field` (`fieldName`, `kind`) VALUES (#{fieldName}, #{kind});")
    void AddField();
}
