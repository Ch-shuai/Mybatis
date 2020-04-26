package com.example.demo.thread;

/**
 * 2020/4/26
 *
 * @author wuzhanhao
 * <p>
 * description:
 *      静态代理类，Thread静态代理，实现Runnable接口，代理runnable接口
 */
public class straticProxy {
    public static void main(String[] args) {

        new Thread(()->System.out.println("woaini")).start();
        new WeddingCompany(new You()).HappyMarry();
    }
}

interface Marry{
    void HappyMarry();
}

//真实角色
class You implements Marry{

    @Override
    public void HappyMarry() {
        System.out.println("自己结婚");
    }
}

//代理角色
class WeddingCompany implements Marry{

    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
        System.out.println("最后，这是一个婚庆公司");
    }

    private void after() {
        System.out.println("婚庆公司代理之后");
    }

    private void before() {
        System.out.println("婚庆公司代理之前");
    }
}
