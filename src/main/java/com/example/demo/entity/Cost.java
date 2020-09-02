package com.example.demo.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * cost
 * @author 
 */
@Data
public class Cost implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 峰价
     */
    private Double fengjia;

    /**
     * 谷价
     */
    private Double gujia;

    /**
     * 尖价
     */
    private Double jianjia;

    /**
     * 需量电费
     */
    private Double xuliang;

    private static final long serialVersionUID = 1L;
}