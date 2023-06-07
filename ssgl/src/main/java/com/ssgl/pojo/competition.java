package com.ssgl.pojo;

import lombok.Data;

import java.util.Date;


@Data
public class competition{
    private Integer competitionid;
    private String competitionName;
    private String place;
    private Date date;
    private String starttime;
    private String endtime;
}
