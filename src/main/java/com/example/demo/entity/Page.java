package com.example.demo.entity;

import lombok.Data;

import java.util.List;

/**
 * 2020/3/9
 *
 * @author wuzhanhao
 */

@Data
public class Page<T> {

    /**
     *  分页起始页
     */
    private int page;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 返回的记录集合
     */
    private List<T> rows;
    /**
     * 总记录条数
     */
    private long total;

}
