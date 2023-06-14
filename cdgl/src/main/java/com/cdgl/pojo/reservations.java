package com.cdgl.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class reservations {
    Integer reservation_id;
    Integer fieldid;
    Date reservation_date;
    String starttime;
    String endtime;
    String username;
    String hour;

}

