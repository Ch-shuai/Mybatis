package com.example.demo.web.result;

import lombok.Data;

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

    public Result(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
