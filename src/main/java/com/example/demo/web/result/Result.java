package com.example.demo.web.result;

import lombok.Data;

import java.util.ArrayList;

/**
 * 2020/3/11
 *
 * @author wuzhanhao
 * <p>
 * description:
 *      wed端的返回码
 */
@Data
public class Result {
    /**
     *     响应码
     */

    private int code;
    private String msg;
    private int count;
    private ArrayList data;


}
