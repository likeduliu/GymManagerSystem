package com.cdgl.controller;

import com.cdgl.mapper.fieldMapper;
import com.cdgl.mapper.fieldNoticeMapper;
import com.cdgl.pojo.field;
import com.cdgl.pojo.fieldnotice;
import com.cdgl.pojo.reservations;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/field")
public class TestController {

    @Autowired
    private fieldMapper fieldMapper;
    @Autowired
    private fieldNoticeMapper fieldNoticeMapper;


    //查询全部场地
    @GetMapping("/")
    public List<field> index(){
        List<field> all=fieldMapper.findAll();
        return all;
    }
    //查询已经预约的场地
    @RequestMapping("/unBook")
    public List<field> unbook(){
        List<field> all =fieldMapper.findAll();
        return all;
    }
    @RequestMapping("/unBook1")
    public List<reservations> unbook1(){
        List<reservations> reservation =fieldMapper.unbook1();
        return reservation;
    }
    @RequestMapping("/unBook2/{fieldid}")
    public List<reservations> unbook2(@PathVariable Integer fieldid){
        List<reservations> reservation =fieldMapper.unbook2(fieldid);
        System.out.println(reservation);
        return reservation;

    }
    //查询未预约的场地
    @RequestMapping("/Booked")
    public List<reservations> booked(){
        List<reservations> bookedfield =fieldMapper.unbook1();
        return bookedfield;
    }




    //查询公告
    @RequestMapping("/Notice")
    public List<fieldnotice> fieldnotice(){
        List<fieldnotice> allnotice=fieldNoticeMapper.findAllNotice();
        return  allnotice;
    }
    //编辑公告中的查询
    @RequestMapping("/NoticeEdit/{fieldnoticeid}")
    public fieldnotice fefieldnotice(@PathVariable Integer fieldnoticeid){
        fieldnotice fefieldnotice=fieldNoticeMapper.fefieldnotice(fieldnoticeid);
        return fefieldnotice;
    }
    @RequestMapping("/UpdateFieldNotice")
    public void updateFieldNotice(@RequestBody fieldnotice fieldnotice){
            fieldNoticeMapper.updateFieldNotice(fieldnotice);
    }
    @RequestMapping("/NoticeDelete/{fieldnoticeid}")
    public void deleteFieldNotice(@PathVariable Integer fieldnoticeid){
        fieldNoticeMapper.deleteFieldNotice(fieldnoticeid);
    }
    @RequestMapping("/AddFieldNotice")
    public void addnotice(@RequestBody fieldnotice fieldnotice){
        fieldNoticeMapper.addFieldNotice(fieldnotice);
    }





    //删除场地
        @DeleteMapping("/Del/{fieldid}")
        public void del(@PathVariable Integer fieldid){
            fieldMapper.DelField(fieldid);
            fieldMapper.UpdateFieldId(fieldid);
    }
    //添加场地
    @PostMapping("/Add")
    public void addfield(@RequestBody field field){
//        System.out.println(field);
        fieldMapper.AddField(field);
        System.out.println(field.getLocation());

    }

    //预约场地
    @PostMapping("/Book")
    public boolean bookfield(@RequestBody reservations reservation){
        List<reservations> TimeCheck= fieldMapper.FieldBookCheckTime(reservation);
        List<reservations> DateCheck=fieldMapper.FieldBookCheckDate(reservation);
        boolean isTimeEmpty=TimeCheck.isEmpty();
        boolean isDateEmpty=DateCheck.isEmpty();

        System.out.println(isDateEmpty);
        System.out.println(isTimeEmpty);
        if (isDateEmpty==true){
            fieldMapper.BookField1(reservation);
            return true;
        }else if(isTimeEmpty==true&&isDateEmpty==true)
        {
            fieldMapper.BookField1(reservation);
            return true;
        }else {
            return false;
        }
//        fieldMapper.BookField1(reservation);
//        return true;
    }
    //取消预约场地
    @RequestMapping("/CancleBook/{reservation_id}")
    public void cancleBook(@PathVariable Integer reservation_id){
        fieldMapper.CancleBook(reservation_id);
    }

//    public void checkbook(reservations reservations){
//        String day=reservations.getReservation_date()+"";
//        String starttime=reservations.getStarttime();
//        String endtime=reservations.getEndtime();
//
//        String sql = "SELECT COUNT(*) FROM reservations " +
//                "WHERE reservation_date = ? " +
//                "AND ((starttime >= ? AND starttime <= ?) " +
//                "OR (starttime <= ? AND endtime >= ?) " +
//                "OR (endtime >= ? AND endtime <= ?))";
//
//
//
//
//        }

}