package com.yhgl.entity;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@TableName("user")
public class LoginForm {
    @Id
    private String UserID;
    private String Password;

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "UserID='" + UserID + '\'' +
                ", Password='" + Password + '\'' +

                '}';
    }
}
