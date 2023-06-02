package com.cdgl.mapper;

import com.cdgl.pojo.field;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface fieldMapper {

    @Select("Select * from field")
    List<field> findAll();

    @Delete("Delete from field where fieldid=#{fieldid} ")
    void DelField(Integer fieldid);
    @Update("ALTER TABLE field AUTO_INCREMENT = #{fieldid}")
    void UpdateFieldId(Integer fieldid);


    @Insert("INSERT INTO `field` (`fieldName`, `kind`) VALUES (#{fieldName}, #{kind});")
    void AddField(field field);

}
