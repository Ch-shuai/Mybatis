package com.example.demo.thread;

import org.apache.poi.ss.formula.functions.T;

public class UnsafeByticket {

    public static void main(String[] args) {

        buyTicket buyTicket = new buyTicket();

        new Thread(buyTicket,"wu").start();
        new Thread(buyTicket,"zhan").start();
        new Thread(buyTicket,"hao").start();
    }
}
class buyTicket implements Runnable{

    private Integer tickerNUm = 10;
    boolean flag = true;
  @Override
    public void run() {
      while (flag){
            buy();
        }
    }

    private void buy(){
        if (tickerNUm<=0){
            flag=false;
            return;
        }
        tickerNUm-=1;
        System.out.println(Thread.currentThread().getName() + "买到了第" + tickerNUm );
    }
}
