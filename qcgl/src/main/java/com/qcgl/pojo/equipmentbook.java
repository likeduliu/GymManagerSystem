package com.qcgl.pojo;
        import lombok.Data;

        import java.util.Date;


@Data
public class equipmentbook {


    private Integer equipmentid;
    private Integer bookid;
    private String bookusername;
    private Date bookstarttime;
    private Date bookendtime;
    private String bookamount;
    private String UserID;



}
