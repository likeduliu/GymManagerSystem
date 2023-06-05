package com.yhgl.Controller;

import com.yhgl.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        // 进行登录验证，验证成功则返回用户信息，否则返回错误信息
        User loginUser = jdbcTemplate.queryForObject(
                "SELECT * FROM user WHERE UserID = ? AND Password = ?",
                new Object[] { user.getUserID(), user.getPassword() },
                (rs, rowNum) -> {
                    User u = new User();
                    u.setUserID(rs.getString("userid"));
                    u.setPassword(rs.getString("password"));
                    u.setName(rs.getString("name"));
                    return u;
                });
        if (loginUser != null) {
            loginUser.setPassword(null);
            return ResponseEntity.ok(loginUser);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}



