package com.example.demo.thread;

/**
 * 2020/4/26
 *
 * @author wuzhanhao
 * <p>
 * description:
 *  lamda表达式
 */
public class lamda {

    //静态内部类
    static class ILike2 implements Like{
        @Override
        public void lamda() {
            System.out.println("I Like lamda2");
        }
    }



    public static void main(String[] args) {
        ILike iLike = new ILike();
        iLike.lamda();

        ILike2 iLike2 = new ILike2();
        iLike2.lamda();

        Like like4 = ()->{
            System.out.println("Final lamda ");
        };
        like4.lamda();
    }
}

interface Like{
    void lamda();
}

class ILike implements Like{
    @Override
    public void lamda() {
        System.out.println("I Like lamda");
    }
}
