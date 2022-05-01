package com.example.videomanagementsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@MapperScan(basePackages = "com.example.videomanagementsystem.mapper")
public class VideoManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideoManagementSystemApplication.class, args);
    }

}
