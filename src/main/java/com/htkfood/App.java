package com.htkfood;

import org.mybatis.spring.annotation.MapperScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.htkfood.dao*")
// 启用缓存注解
@EnableCaching
public class App {
    public static  void  main(String[]args){
        SpringApplication.run(App.class,args);
    }
}
