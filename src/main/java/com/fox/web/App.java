package com.fox.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by linxiaofang on 2017/8/29.
 */

//@RestController
@SpringBootApplication
@MapperScan("com.fox.web.mapper")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
