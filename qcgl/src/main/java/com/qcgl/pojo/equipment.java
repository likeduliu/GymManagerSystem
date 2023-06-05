package com.qcgl.pojo;

import lombok.Data;

import java.util.Date;


@Data
public class equipment {
    private Integer equipmentid;
    private String equipmentname;
    private String amount;
    private String state;
    private String rate;
    private String bookusername;
    private Date bookstarttime;
    private Date bookendtime;



}
