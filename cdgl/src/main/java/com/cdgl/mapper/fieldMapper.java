package com.cdgl.mapper;

import com.cdgl.pojo.field;
import com.cdgl.pojo.fieldnotice;
import com.cdgl.pojo.reservations;
import com.sun.org.apache.xerces.internal.xs.StringList;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Repository
public interface fieldMapper {


    //查询全部场地
    List<field> findAll();
    //查询未预约的场地
    List<reservations> unbook1();
    //查询已预约场地
    List<field> booked();

    List<reservations> unbook2(Integer fieldid);

    //删除并更新
    public void DelField(Integer fieldid);

    public void UpdateFieldId(Integer fieldid);
    //添加场地
    public void AddField(field field);
    //预约场地
    @Select("Select * from field")
    public void BookField(reservations reservation);

    //计算日期差

    public void BookField1(reservations reservation);
    //判断日期
   @Select("SELECT * FROM reservations WHERE reservation_date = '#{reservation_date}'  AND ((starttime >= '#{starttime}' AND starttime <= '#{endtime}')  OR (starttime <= '#{starttime}' AND endtime >= '#{endtime}') OR (endtime >= '#{starttime}' AND endtime <= '#{endtime}') );")
   public List<reservations> FieldBookCheck(reservations reservations);

    public List<reservations> FieldBookCheckTime(reservations reservations);

    public List<reservations> FieldBookCheckDate(reservations reservations);

    //取消预约
    public void CancleBook(Integer reservation_id);

    public void canlbookbydel(Integer fiedlid);

    //判断数量
    public int bookNum(reservations reservations);

    public List<reservations> FieldExist(reservations reservations);





}
