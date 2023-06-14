package com.ssgl.controller;

import com.ssgl.mapper.competitionMapper;
import com.ssgl.pojo.competition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/competition")
public class testcontroller{

    @Autowired
    private competitionMapper competitionMapper;

    //查询全部比赛
    @RequestMapping("")
    public  List<competition>   index(){
        System.out.println("sss");
        List<competition> all=competitionMapper.findAll();
        return all;
    }
    //删除比赛
    @RequestMapping("/Del/{competitionid}")
    public void del(@PathVariable Integer competitionid){
        competitionMapper.DelCompetition(competitionid);
        competitionMapper.UpdateCompetitionId(competitionid);
    }
    //创办比赛
    @RequestMapping("/Add")
    public void addcompetition(@RequestBody competition competition){
        competitionMapper.Addcompetition(competition);

    }
}