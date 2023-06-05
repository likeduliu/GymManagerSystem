package com.cdgl.controller;

import com.cdgl.mapper.fieldMapper;
import com.cdgl.pojo.field;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/field")
public class TestController {

    @Autowired
    private fieldMapper fieldMapper;


    //查询全部场地
    @GetMapping("/")
    public List<field> index(){
        List<field> all=fieldMapper.findAll();
        return all;

    }
    //查询已经预约的场地
    @RequestMapping("/unBook")
    public List<field> unbook(){
        List<field> unbookfield =fieldMapper.unbook();
        return unbookfield;
    }
    //查询未预约的场地
    @RequestMapping("/Booked")
    public List<field> booked(){
        List<field> bookedfield =fieldMapper.booked();
        return bookedfield;
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

    }
    //预约场地
    @PostMapping("/Book")
    public void bookfield(@RequestBody field field){
        fieldMapper.BookField(field);
    }
    //取消预约场地
    @RequestMapping("/CancleBook/{fieldid}")
    public void cancleBook(@PathVariable Integer fieldid){
        fieldMapper.CancleBook(fieldid);
    }


}