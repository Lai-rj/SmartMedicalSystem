package com.example.smartmedicalsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.smartmedicalsystem.mapper")
public class SmartMedicalSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartMedicalSystemApplication.class, args);
    }

}
