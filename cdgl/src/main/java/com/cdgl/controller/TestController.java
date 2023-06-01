package com.cdgl.controller;

import com.cdgl.mapper.fieldMapper;
import com.cdgl.pojo.field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private fieldMapper fieldMapper;


    @GetMapping("/")
    public List<field> index(){

        List<field> all=fieldMapper.findAll();
        return all;

    }

}