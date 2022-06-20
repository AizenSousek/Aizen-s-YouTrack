package com.aizensousek.bigprize;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.aizensousek.aytserver.dao")
public class AytServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AytServerApplication.class, args);
    }

}