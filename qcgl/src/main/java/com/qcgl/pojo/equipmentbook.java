package com.qcgl.pojo;
        import lombok.Data;

        import java.util.Date;



public class equipmentbook {


    private Integer equipmentid;
    private Integer bookid;
    private String bookusername;

    public Integer getEquipmentid() {
        return equipmentid;
    }

    public void setEquipmentid(Integer equipmentid) {
        this.equipmentid = equipmentid;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getBookusername() {
        return bookusername;
    }

    public void setBookusername(String bookusername) {
        this.bookusername = bookusername;
    }

    public Date getBookstarttime() {
        return bookstarttime;
    }

    public void setBookstarttime(Date bookstarttime) {
        this.bookstarttime = bookstarttime;
    }

    public Date getBookendtime() {
        return bookendtime;
    }

    public void setBookendtime(Date bookendtime) {
        this.bookendtime = bookendtime;
    }

    public String getBookamount() {
        return bookamount;
    }

    public void setBookamount(String bookamount) {
        this.bookamount = bookamount;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    private Date bookstarttime;
    private Date bookendtime;
    private String bookamount;
    private String UserID;



}
