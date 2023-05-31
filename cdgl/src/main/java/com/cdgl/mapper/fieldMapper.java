package com.cdgl.mapper;

import com.cdgl.pojo.field;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface fieldMapper {

    @Select("SELECT *from field")
    List<field> findAll();
}
