package com.cdgl.service.Impl;

import com.cdgl.mapper.fieldMapper;
import com.cdgl.pojo.field;
import com.cdgl.pojo.fieldnotice;
import com.cdgl.service.fieldService;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class fieldServiceImpl{

//    private final fieldMapper fieldMapper;
//
//    @Autowired
//    public fieldServiceImpl(fieldMapper fieldMapper){
//        this.fieldMapper=fieldMapper;
//    }
//
//    @Select("SELECT * from field")
//    List<field> findAll();
//    @Select("Select *from field where book='2' ")
//    List<field> unbook();
//    @Select("Select *from field where book='1'")
//    List<field> booked();
//
//    @Select("Select * from fieldnotice")
//    List<fieldnotice> findAllNotice();
//
//    @Select("Select *from fieldnotice where fieldnoticeid=#{fieldnoticeid}")
//    fieldnotice fefieldnotice(Integer fieldnoticeid);
//
//    @Update("UPDATE fieldnotice SET fieldnoticetitle=#{fieldnoticetitle},fieldnoticebody={fieldnoticebody} WHERE fieldnoticeid=#{fieldnoticeid}")
//    public void updateFieldNotice(fieldnotice fieldnotice);
//
//    @Delete("Delete from fieldnotice where fieldnoticeid=#{fieldnoticeid} ")
//    public void deleteFieldNotice(Integer fieldnoticeid);
//
//    @Insert("INSERT INTO `fieldnotice` (`fieldNoticeTitle`, `fieldNoticeBody`) VALUES (#{fieldnoticetitle}, #{fieldnoticebody});")
//    public void addFieldNotice(fieldnotice fieldnotice);
//
//    @Delete("Delete * from field where fieldid=#{fieldid}")
//    String DelField();
//    @Update("ALTER TABLE field AUTO_INCREMENT = #{fieldid}")
//    void UpdateFieldId(Integer fieldid);
//    @Insert("INSERT INTO `field` (`fieldName`, `kind`) VALUES (#{fieldName}, #{kind}, #{book});")
//    void AddField();
//    @Update("UPDATE field SET book = 1,bookusername=#{bookusername},bookstarttime=#{bookstarttime},bookendtime=#{bookendtime} WHERE fieldid = #{fieldid};")
//    public void BookField(field field);
//    @Update("UPDATE field SET book=2 WHERE fieldid=#{fieldid}")
//    public void CancleBook(Integer fieldid);
//



}
