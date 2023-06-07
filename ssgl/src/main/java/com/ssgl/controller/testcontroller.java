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
    @GetMapping("/")
    public  List<competition> index(){
        List<competition> all=competitionMapper.findAll();
        return all;
    }
    //删除比赛
    @DeleteMapping("/Del/{competitionid}")
    public void del(@PathVariable Integer competitionid){
        competitionMapper.DelCompetition(competitionid);
        competitionMapper.UpdateCompetitionId(competitionid);
    }
    //创办比赛
    @PostMapping("/Add")
    public void addcompetition(@RequestBody competition competition){
        competitionMapper.Addcompetition(competition);

    }
}