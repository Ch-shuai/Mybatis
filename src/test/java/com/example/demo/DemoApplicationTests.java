package com.example.demo;

import com.example.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("testBean.xml");
        User user2 = applicationContext.getBean("skr", User.class);
        String name = user2.getName();
        System.out.println(name);
    }

    @Test
    void jisuan(){
        System.out.println(1000==1000);
        System.out.println(100==100);
    }

}
