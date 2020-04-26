package com.example.demo.thread;

/**
 * 2020/4/26
 *
 * @author wuzhanhao
 * <p>
 * description:
 *      创建线程方式2 ：实现Runnable接口，重写run方法，执行线程需要丢去runnable接口实现类，调用start方法
 */
public class Thread2 implements Runnable {

    @Override
    public void run() {
        //run方法的线程体
        for (int i = 0;i<=200;i++){
            System.out.println("实现runnable"+i);
        }
    }

    public static void main(String[] args) {
        new Thread(new Thread2()).start();
        for (int i = 0;i<=200;i++){
            System.out.println("这是主线程"+i);
        }
    }
}
