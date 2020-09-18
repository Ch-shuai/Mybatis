package com.example.demo.util;

import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 2020/3/17
 *
 * @author wuzhanhao
 * <p>
 * description:
 *      Quartz触发器
 *      Quartz触发器
 */
public class QuartzStartListener implements ServletContextListener {


        @Override
        public void contextInitialized(ServletContextEvent sce) {
                //使用StdSchedulerFactory工厂创建一个调度器
                StdSchedulerFactory schedulerFactory = new StdSchedulerFactory();
                Scheduler scheduler = null;
/**
 */

        }

        @Override
        public void contextDestroyed(ServletContextEvent sce) {

        }
    }
