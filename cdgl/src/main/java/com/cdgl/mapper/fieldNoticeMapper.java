package com.cdgl.mapper;


import com.cdgl.pojo.fieldnotice;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface fieldNoticeMapper {

    //查询公告
    @Select("Select * from fieldnotice")
    List<fieldnotice> findAllNotice();
    //编辑公告中的查询
    @Select("Select *from fieldnotice where fieldnoticeid=#{fieldnoticeid}")
    fieldnotice fefieldnotice(Integer fieldnoticeid);
    //更新公告
    @Update("UPDATE fieldnotice SET fieldNoticeTitle=#{fieldnoticetitle},fieldNoticeBody=#{fieldnoticebody} WHERE fieldnoticeid=#{fieldnoticeid}")
    public void updateFieldNotice(fieldnotice fieldnotice);
    //删除公告
    @Delete("Delete from fieldnotice where fieldnoticeid=#{fieldnoticeid} ")
    public void deleteFieldNotice(Integer fieldnoticeid);

    //添加公告
    @Insert("INSERT INTO `fieldnotice` (`fieldNoticeTitle`, `fieldNoticeBody`) VALUES (#{fieldnoticetitle}, #{fieldnoticebody});")
    public void addFieldNotice(fieldnotice fieldnotice);
}
