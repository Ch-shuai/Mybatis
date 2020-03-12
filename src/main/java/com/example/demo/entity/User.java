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
    private String id;
    private String username;
    private String password;

}
