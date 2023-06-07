package com.ssgl.service;

import com.ssgl.pojo.competition;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface competitonService {

    //查询比赛
    @Select("Select * from competition")
    List<competition> findAll();

    //取消比赛并更新
    @Delete("Delete from competition where competionid=#{competition} ")
    public void DelCompetiton(Integer competitionid);

    @Update("ALTER TABLE competition AUTO_INCREMENT = #{competitionid}")
    public void UpdateCompetitionId(Integer competitionid);

    //创办比赛
    @Insert("INSERT INTO `competition` (`competitionname`, `place`,`data`,`starttime`,`endtime`) VALUES (#{competitionname}, #{place}, #{data},#{starttime},#{endtime});")
    public void Addcompetition(competition competition);
}