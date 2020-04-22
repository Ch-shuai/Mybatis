package com.example.demo.controller;

import com.example.demo.web.page.TableDataInfo;
import com.example.demo.web.result.CodeMsg;
import com.example.demo.web.result.Result;
import com.github.pagehelper.PageInfo;

import java.util.List;

public class BaseController {

    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    protected Result<TableDataInfo> getDataTable(List<?> list) {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        return Result.successData(rspData);
    }

    /**
     * 响应单个数据
     *
     * @param data
     * @return
     */
    protected <T> Result<T> getResultData(T data) {
        Result<T> result = Result.successData(data);
        return result;
    }

    protected Result<String> toResult(int rows) {
        return rows > 0 ? Result.success() : Result.error();
    }

    /**
     * 成功时候调用
     *
     * @return
     */
    public Result<String> success() {
        return Result.success();
    }

    /**
     * 失败时候调用
     *
     * @return
     */
    public Result<String> error() {
        return Result.error();
    }

    /**
     * 返回成功消息
     */
    public Result<String> success(String message) {
        return Result.success(message);
    }

    /**
     * 返回失败消息
     */
    public Result<String> error(String message) {
        return Result.error(message);
    }

    /**
     * 返回错误码消息
     */
    public Result<String> error(CodeMsg codeMsg) {
        return Result.error(codeMsg);
    }

}
