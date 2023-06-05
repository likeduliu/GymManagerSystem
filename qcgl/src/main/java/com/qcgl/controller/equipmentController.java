package com.qcgl.controller;

import com.qcgl.mapper.equipmentMapper;
import com.qcgl.pojo.equipment;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipment")
public class equipmentController {

    @Autowired
    private equipmentMapper equipmentMapper;


    //查询全部器材
    @GetMapping("/")
    public List<equipment> index() {
        List<equipment> all = equipmentMapper.findAll();
        return all;

    }
    //添加器材
    @PostMapping("/Add")
    public void addequipment(@RequestBody equipment equipment){
        equipmentMapper.Addequipment(equipment);

    }
    //删除器材然后更新器材
    @DeleteMapping("/Del/{equipmentid}")
    public void del(@PathVariable Integer equipmentid){
        equipmentMapper.Delequipment(equipmentid);
        equipmentMapper.Updateequipment(equipmentid);
        System.out.println(equipmentid);
    }













}