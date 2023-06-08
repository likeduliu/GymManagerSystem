package com.cdgl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class CdglApplication {

    public static void main(String[] args) {
        SpringApplication.run(CdglApplication.class, args);
    }

}
