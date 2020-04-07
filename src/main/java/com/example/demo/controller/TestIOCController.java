package com.example.demo.controller;


import com.example.demo.service.impl.TestIOCServiceImpl;

/**
 * 2020/4/2
 *
 * @author wuzhanhao
 * <p>
 * description:
 */
public class TestIOCController {

    public static void main(String[] args) {
        TestIOCServiceImpl testIOCService = new TestIOCServiceImpl();
        String s = testIOCService.returnStr();

    }
}
