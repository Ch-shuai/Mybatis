package com.example.demo.entity;

/**
 * 前端传递的实体类
 *           {"name":"杭州御数信息技术有限公司",
 *           "industry":"信息技术公司",
 *           "price_min":"50","price_max":"60",
 *           0表示升序，1表示降序
 *           "order":"0",
 *           "quiz1":"浙江","quiz2":"温州","quiz3":"西湖区"}
 */
public class Form {
     private String name;
     private String price_min;
     private String price_max;
     private Integer order;
     private String quiz1;
     private String quiz2;
     private String quiz3;

    @Override
    public String toString() {
        return "Form{" +
                "name='" + name + '\'' +
                ", price_min='" + price_min + '\'' +
                ", price_max='" + price_max + '\'' +
                ", order=" + order +
                ", quiz1='" + quiz1 + '\'' +
                ", quiz2='" + quiz2 + '\'' +
                ", quiz3='" + quiz3 + '\'' +
                '}';
    }

    public Form() {
    }

    public Form(String name, String price_min, String price_max, Integer order, String quiz1, String quiz2, String quiz3) {
        this.name = name;
        this.price_min = price_min;
        this.price_max = price_max;
        this.order = order;
        this.quiz1 = quiz1;
        this.quiz2 = quiz2;
        this.quiz3 = quiz3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice_min() {
        return price_min;
    }

    public void setPrice_min(String price_min) {
        this.price_min = price_min;
    }

    public String getPrice_max() {
        return price_max;
    }

    public void setPrice_max(String price_max) {
        this.price_max = price_max;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getQuiz1() {
        return quiz1;
    }

    public void setQuiz1(String quiz1) {
        this.quiz1 = quiz1;
    }

    public String getQuiz2() {
        return quiz2;
    }

    public void setQuiz2(String quiz2) {
        this.quiz2 = quiz2;
    }

    public String getQuiz3() {
        return quiz3;
    }

    public void setQuiz3(String quiz3) {
        this.quiz3 = quiz3;
    }
}
