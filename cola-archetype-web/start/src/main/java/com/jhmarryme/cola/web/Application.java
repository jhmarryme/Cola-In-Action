package com.jhmarryme.cola.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Starter
 *
 * @author Frank Zhang
 */
@SpringBootApplication(scanBasePackages = {"com.jhmarryme.cola.web","com.alibaba.cola", "com.jhmarryme.cola.config"})
@MapperScan("com.jhmarryme.cola.web.gatewayimpl.database.mybatis")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
