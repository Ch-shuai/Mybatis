package com.example.demo.thread;

import com.example.demo.utils.JsonUtils;
import org.w3c.dom.ls.LSOutput;

import javax.annotation.Priority;

/**
 * 2020/4/26
 *
 * @author wuzhanhao
 * <p>
 * description:
 *
 *      测试线程优先级
 *              先设置优先级在启动
 */
public class TestPriority {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyPriority());
        Thread thread2 = new Thread(new MyPriority());
        Thread thread3 = new Thread(new MyPriority());
        Thread thread4 = new Thread(new MyPriority());
        Thread thread5 = new Thread(new MyPriority());
        Thread thread6 = new Thread(new MyPriority());
        Thread thread7 = new Thread(new MyPriority());
        Thread thread8 = new Thread(new MyPriority());
        Thread thread9 = new Thread(new MyPriority());

        thread1.setPriority(2);
    }
}
class MyPriority implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"Name"+Thread.currentThread().getPriority()+"priority");
    }
}
