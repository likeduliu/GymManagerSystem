package com.qcgl.controller;

import com.qcgl.mapper.equipmentMapper;
import com.qcgl.pojo.equipment;
import com.qcgl.pojo.equipmentbook;
import com.qcgl.pojo.equipmentrecover;
import com.qcgl.pojo.equipmentrepair;
import com.sun.javaws.IconUtil;
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


        //查询器材收费标准
        @GetMapping("/QueryRate/{equipmentid}")
        public List<equipment> QueryRate(@PathVariable Integer equipmentid) {
            List<equipment> allrate = equipmentMapper.QueryRate(equipmentid);
            System.out.println(equipmentid);
            return allrate;
    }



    //查询租用的器材
    @GetMapping("/Book/{userID}")
    public List<equipmentbook> QueryBook(@PathVariable String userID) {
        List<equipmentbook> allbook = equipmentMapper.QueryBook(userID);

//        System.out.println(userID);
        return allbook;
    }



    //查询要返还的器材
    @GetMapping("/Recover")
    public List<equipmentbook> QueryRecover() {
        List<equipmentbook> allrecover = equipmentMapper.QueryRecover();

//        System.out.println(userID);
        return allrecover;
    }
    //删除已归还的租用记录
    @DeleteMapping("/Recover/{bookid}")
    public void delbook(@PathVariable Integer bookid){
        equipmentMapper.Delbook(bookid);
        System.out.println(bookid);
    }




    //查询维修的器材
    @GetMapping("/Repair")
    public List<equipmentrepair> QueryRepair() {
        List<equipmentrepair> allrepair = equipmentMapper.QueryRepair();
        return allrepair;

    }

    //添加器材
    @PostMapping("/Add")
    public void addequipment(@RequestBody equipment equipment){
        equipmentMapper.Addequipment(equipment);

    }
    //租用器材
        @PostMapping("/Book")
        public boolean bookequipment(@RequestBody equipmentbook equipmentbook){
//        System.out.println(equipmentbook);
            Integer eid= equipmentbook.getEquipmentid();
            String bookNum =  equipmentMapper.EquNum(eid);
            String booknum = equipmentbook.getBookamount();
            int Amount=Integer.valueOf(bookNum);
            int bookAmount=Integer.valueOf(booknum);
//            equipmentMapper.Bookequipment(equipmentbook);

            // 获取租用器材信息
            if(Amount>=bookAmount){
                equipmentMapper.Bookequipment(equipmentbook);
                System.out.println(true);
                return true;
            }else {
                System.out.println(false);
                return false;
            }

    }

    //返还器材
    @PostMapping("/Recover")
    public void recoverequipment(@RequestBody equipmentrecover equipmentrecover){
        equipmentMapper.Recoverequipment(equipmentrecover);

    }
    //维修器材
    @PostMapping("/Repair")
    public void repairequipment(@RequestBody equipmentrepair equipmentrepair){
        equipmentMapper.Repairequipment(equipmentrepair);

    }

    //删除器材然后更新器材
    @DeleteMapping("/Del/{equipmentid}")
    public void del(@PathVariable Integer equipmentid){
        equipmentMapper.Delequipment(equipmentid);
        equipmentMapper.Updateequipment(equipmentid);
        System.out.println(equipmentid);
    }















}