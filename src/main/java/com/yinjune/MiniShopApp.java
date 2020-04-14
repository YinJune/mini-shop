package com.yinjune;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: YinJunJie
 * @date: 2020/4/13 23:28
 * @description:
 */
@MapperScan(basePackages = {"com.yinjune.dao.mapper"})
@SpringBootApplication
public class MiniShopApp {
    public static void main(String[] args) {
        SpringApplication.run(MiniShopApp.class, args);
    }
}
