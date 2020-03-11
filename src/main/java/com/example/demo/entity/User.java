package com.example.demo.entity;

import lombok.Data;

import java.util.Date;

/**
 * 2020/3/10
 *
 * @author wuzhanhao
 * <p>
 * description:
 */
@Data
public class User {
    private String name;
    private String age;
    private Date birthday;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public User(String name, String age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
