package com.cdgl.pojo;

import lombok.Data;

import java.util.Date;


@Data
public class field {
    private Integer fieldid;
    private String fieldName;
    private String book;
    private String kind;
    private String rate;
    private Date bookstarttime;
    private Date bookendtime;
    private String bookusername;



}
