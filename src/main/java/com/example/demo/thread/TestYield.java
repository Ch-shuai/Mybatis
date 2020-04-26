package com.example.demo.thread;

/**
 * 2020/4/26
 *
 * @author wuzhanhao
 * <p>
 * description:
 *
 *      线程礼让
 */
public class TestYield {
    public static void main(String[] args) {
        new Thread(new MyYield(),"A").start();
        new Thread(new MyYield(),"B").start();

    }
}
class MyYield implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始执行");
        //线程礼让
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"线程停止执行");
    }

}
