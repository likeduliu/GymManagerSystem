package com.cdgl.service;

import com.cdgl.pojo.field;
import com.cdgl.pojo.fieldnotice;
import com.cdgl.pojo.reservations;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;


public interface fieldService {



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
    public void BookField(reservations reservation);


    public void BookField1(reservations reservation);
    //判断日期
    public List<reservations> FieldBookCheck(reservations reservations);

    public List<reservations> FieldBookCheckTime(reservations reservations);

    public List<reservations> FieldBookCheckDate(reservations reservations);

    //取消预约
    public void CancleBook(Integer reservation_id);


    List<fieldnotice> findAllNotice();
    //编辑公告中的查询
    fieldnotice fefieldnotice(Integer fieldnoticeid);
    //更新公告
    public void updateFieldNotice(fieldnotice fieldnotice);
    //删除公告
    public void deleteFieldNotice(Integer fieldnoticeid);

    //添加公告
    public void addFieldNotice(fieldnotice fieldnotice);
    public void canlbookbydel(Integer fieldid);
}
