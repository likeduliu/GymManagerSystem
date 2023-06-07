package com.cdgl.mapper;

import com.cdgl.pojo.field;
import com.cdgl.pojo.fieldnotice;
import com.cdgl.pojo.reservations;
import com.sun.org.apache.xerces.internal.xs.StringList;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface fieldMapper {


    //查询全部场地
    @Select("Select * from field")
    List<field> findAll();
    //查询未预约的场地
    @Select("Select * from reservations")
    List<reservations> unbook1();
    //查询已预约场地
    @Select("Select *from field where book='1'")
    List<field> booked();

    @Select("Select * from reservations where fieldid=#{fieldid}")
    List<reservations> unbook2(Integer fieldid);

    //删除并更新
    @Delete("Delete from field where fieldid=#{fieldid} ")
    public void DelField(Integer fieldid);

    @Update("ALTER TABLE field AUTO_INCREMENT = #{fieldid}")
    public void UpdateFieldId(Integer fieldid);
    //添加场地
    @Insert("INSERT INTO `field` (`fieldName`, `kind`,`book`,`rate`,`location`) VALUES (#{fieldName}, #{kind}, #{book},#{rate},#{location});")
    public void AddField(field field);
    //预约场地
    @Select("Select * from field")
    public void BookField(reservations reservation);

    //计算日期差
//    @Update("UPDATE reservations SET hour = #{hourDiff} WHERE reservation_id = #{reservation_id}")
//    public String hour_diff(long hourDiff,int reservation_id);

    @Insert("INSERT INTO `reservations` (`fieldid`,`reservation_date`,`starttime`,`endtime`,`hour`) VALUES (#{fieldid},#{reservation_date},#{starttime},#{endtime},#{hour});")
    public void BookField1(reservations reservation);
    //判断日期
   @Select("SELECT * FROM reservations WHERE reservation_date = '#{reservation_date}'  AND ((starttime >= '#{starttime}' AND starttime <= '#{endtime}')  OR (starttime <= '#{starttime}' AND endtime >= '#{endtime}') OR (endtime >= '#{starttime}' AND endtime <= '#{endtime}') );")
   public List<reservations> FieldBookCheck(reservations reservations);
    @Select("SELECT * FROM reservations WHERE ((starttime > #{starttime} AND starttime < #{endtime}) "+
            "OR (starttime < #{starttime} AND endtime > #{endtime}) "+
            "OR (endtime > #{starttime} AND endtime < #{endtime})  "+
            "OR (starttime = #{starttime} AND endtime < #{endtime})"+
            "OR (starttime = #{starttime} AND endtime > #{endtime})"+
            "OR (endtime = #{endtime} AND starttime > #{starttime})"+
            "OR (endtime = #{endtime} AND starttime > #{starttime})"+
            ");")
    public List<reservations> FieldBookCheckTime(reservations reservations);

    @Select("SELECT * FROM reservations WHERE reservation_date = #{reservation_date}")
    public List<reservations> FieldBookCheckDate(reservations reservations);

    //取消预约
    @Delete("Delete from reservations WHERE reservation_id=#{reservation_id}")
    public void CancleBook(Integer reservation_id);



    //更新费用表
//    @Insert()
//    public void  InsertCoast();
}
