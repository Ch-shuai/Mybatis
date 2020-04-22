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
@Data
public class Result<T> {

    private int code;

    private String msg;

    private T data;

    private Result() {

    }

    private Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private Result(T data) {
        this.data = data;
    }

    private Result(String msg) {
        this.msg = msg;
    }

    private Result(CodeMsg codeMsg) {
        this.msg = codeMsg.getMsg();
        this.code = codeMsg.getCode();
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

    /**
     * @param msg 返回消息
     * @return
     */
    public static <T> Result<T> success(String msg) {
        return new Result<T>( msg );
    }

    /**
     * 操作成功
     *
     * @return
     */
    public static <T> Result<T> success() {
        return new Result<T>( 0, "操作成功", null );
    }

    /**
     * 成功时候调用
     *
     * @param data
     * @return
     */
    public static <T> Result<T> successData(T data) {
        return new Result<T>( data );
    }

    /**
     * 失败时候调用
     *
     * @param codeMsg
     * @return
     */
    public static <T> Result<T> error(CodeMsg codeMsg) {
        return new Result<T>( codeMsg );
    }

    /**
     * 无参调用
     *
     * @return
     */
    public static <T> Result<T> error() {
        return new Result<T>( 500, "操作失败", null );
    }


    /**
     * @param code 异常信息
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> Result<T> error(Integer code, String msg) {
        return new Result<T>( code, msg, null );
    }

    /**
     * 失败时候调用
     *
     * @param codeMsg
     * @return
     */
    public static <T> Result<T> error(String msg) {
        return new Result<T>( 500, msg, null );
    }

}
