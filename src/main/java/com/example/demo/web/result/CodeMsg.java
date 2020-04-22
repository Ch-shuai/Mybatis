package com.example.demo.web.result;

/**
 *  所有错误封装CodeMsg, 统一处理
 */
public class CodeMsg {

    private int code;
    private String msg;

    public CodeMsg() {
    }

    public CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
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

    public static CodeMsg ERR_ACTION = new CodeMsg(500500,"操作错误");
}
