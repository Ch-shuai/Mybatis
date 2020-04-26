package com.example.demo.thread;

/**
 * 2020/4/26
 *
 * @author wuzhanhao
 * <p>
 * description:
 *
 *      创建线程方法：继承Thread类，重写run方法，调用start开启线程
 *
 *      线程执行顺序由CPU调度，
 */

public class Thread1 extends Thread{

    //线程执行体
    @Override
    public void run() {
        //run方法线程体
        for (int i = 0;i<=20;i++){
            System.out.println("FIGHTING" + i);

        }
    }

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        //调用线程的start方法开启线程
        thread1.start();

        for (int i = 0;i<=200;i++){
            System.out.println("我是主线程" + i);
        }
    }
}
