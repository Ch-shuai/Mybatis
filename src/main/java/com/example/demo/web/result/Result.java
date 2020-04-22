package com.example.demo.web.result;

import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;

/**
 * 2020/3/11
 *
 * @author wuzhanhao
 * <p>
 * description:
 *      wed端的返回码
 */
public class Result {

    /**
     *     响应码
     */
    private int code;
    private String msg;
    private T data;

    public Result() {
    }

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
