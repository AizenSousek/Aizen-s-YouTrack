package com.aizensousek.bigprize;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.aizensousek.bigprize.dao")
public class BigPrizeServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BigPrizeServerApplication.class, args);
    }

}