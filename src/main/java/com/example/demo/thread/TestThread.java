package com.example.demo.thread;

/**
 * 2020/4/26
 *
 * @author wuzhanhao
 * <p>
 * description:
 *
 *  多个线程操作一个对象，
 */
public class TestThread implements Runnable {

    //票数
    private int ticketNum = 10000;

    @Override
    public void run() {
        while (true){
            if (ticketNum <= 0){
                break;
            }
            try{
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"拿到了第"+ticketNum--+"张票");
        }
    }

    public static void main(String[] args) {
        //  the name of the new thread,
        new Thread(new TestThread(),"小明").start();
        new Thread(new TestThread(),"小刚").start();
        new Thread(new TestThread(),"黄牛").start();
    }
}
