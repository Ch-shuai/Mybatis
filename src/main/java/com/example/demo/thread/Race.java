package com.example.demo.thread;

/**
 * 2020/4/26
 *
 * @author wuzhanhao
 * <p>
 * description:
 *
 *      一个测试类，实现龟兔赛跑
 */
public class Race implements Runnable {


    @Override
    public void run() {
        //模拟兔子睡觉，线程sleep
        if (Thread.currentThread().getName().equals("兔子")){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i <= 100; i++) {

            if (winner(i)){
                break;
            }
            String ThreadName = Thread.currentThread().getName();
            System.out.println(ThreadName+"-->跑了" + i +"步" );
        }
    }
    public synchronized boolean winner(int i){
        if (i==100){
            String name = Thread.currentThread().getName();
            System.out.println("winner is" + name);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        new Thread(new Race(),"乌龟").start();
        new Thread(new Race(),"兔子").start();

    }
}
