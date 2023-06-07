package com.ssgl.mapper;

import com.ssgl.pojo.competition;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface competitionMapper {

    //查询比赛
    @Select("Select * from competition")
    List<competition> findAll();

    //取消比赛并更新
    @Delete("Delete from competition where competitionid=#{competitionid} ")
    public void DelCompetition(Integer competitionid);

    @Update("ALTER TABLE competition AUTO_INCREMENT = #{competitionid}")
    public void UpdateCompetitionId(Integer competitionid);

    //创办比赛
    @Insert("INSERT INTO `competition` (`competitionName`, `place`,`date`,`starttime`,`endtime`) VALUES (#{competitionName}, #{place}, #{date},#{starttime},#{endtime});")
    public void Addcompetition(competition competition);
}