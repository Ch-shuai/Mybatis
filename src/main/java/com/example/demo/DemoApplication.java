package com.example.demo;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Spring Boot 使用事务非常简单，首先使用注解 @EnableTransactionManagement
 * 开启事务支持后，然后在访问数据库的Service方法上添加注解 @Transactional 便可。
 */
@SpringBootApplication(scanBasePackages = "com.example.demo")
@EnableTransactionManagement
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
