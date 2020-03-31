package com.example.demo.config;

import com.example.demo.service.MaterialService;
import org.springframework.boot.context.event.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * 2020/3/31
 *
 * @author wuzhanhao
 * <p>
 * description:
 *      时间监听处理
 */
public class TestApplicationListener implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationEvent){
            System.out.println("未作任何处理（除listener注册和初始化）的时候发送ApplicationStartingEvent");
            return;
        }
        if (event instanceof ApplicationEnvironmentPreparedEvent){
            System.out.println("确定springboot应用使用的Environment且context创建之前发送这个事件");
        }
        //context已经创建且没有refresh发送个事件
        if (event instanceof ApplicationPreparedEvent){
            System.out.println("ApplicationPrepared");
            return;
        }
        //context已经refresh且application and command-line runners（如果有） 调用之前发送这个事件
        if (event instanceof ApplicationStartedEvent){
            System.out.println("ApplicationStarted");
            return;
        }
        //application and command-line runners （如果有）执行完后发送这个事件，此时应用已经启动完毕
        if (event instanceof ApplicationReadyEvent){
            ApplicationContext context = ((ApplicationReadyEvent) event).getApplicationContext();
            MaterialService contextBean = context.getBean(MaterialService.class);
            return;
        }
        //应用启动失败后产生这个事件
        if (event instanceof ApplicationFailedEvent){
            System.out.println("ApplicationFailed");
            return;
        }
    }
}
