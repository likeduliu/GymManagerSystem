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


    @GetMapping("/")
    public List<field> index(){

        List<field> all=fieldMapper.findAll();
        return all;

    }
    @DeleteMapping("/Del/{fieldid}")
    public void del(@PathVariable Integer fieldid){
        fieldMapper.DelField(fieldid);
        fieldMapper.UpdateFieldId(fieldid);
    }
    @PostMapping("/Add")
    public void addfield(@RequestBody field field){
//        System.out.println(field);
        fieldMapper.AddField(field);

    }

}