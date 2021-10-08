package com.mlming.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mlming.springboot.dao")
public class SapmallApplication {

    public static void main(String[] args) {
        SpringApplication.run(SapmallApplication.class, args);
    }

}
