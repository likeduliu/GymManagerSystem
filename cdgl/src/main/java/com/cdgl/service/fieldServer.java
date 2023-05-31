package com.cdgl.service;

import com.cdgl.pojo.field;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface fieldServer {

    @Select("SELECT * from field")
    List<field> findAll();
    @Insert("")
    field newField();
}
