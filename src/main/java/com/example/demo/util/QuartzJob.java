package com.example.demo.util;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2020/3/17
 *
 * @author wuzhanhao
 * <p>
 * description:
 *      Job： 是一个接口，只定义一个方法execute(JobExecutionContext context)，
 *      在实现接口的execute方法中编写所需要定时执行的Job(任务)，
 *      JobExecutionContext类提供了调度应用的一些信息。Job运行时的信息保存在JobDataMap实例中；
 */
@RequestMapping("Quartz")
@RestController
public class QuartzJob implements Job {


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Hello Quartz !");
    }
}
