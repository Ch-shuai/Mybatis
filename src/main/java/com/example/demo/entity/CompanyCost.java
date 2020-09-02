package com.example.demo.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * company
 * @author 
 */
@Data
public class CompanyCost implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 公司名称
     */
    private String name;

    /**
     * 优化前峰量电费
     */
    private Double fengliangBefore;

    /**
     * 优化前谷量电费
     */
    private Double guliangBefore;

    /**
     * 优化前尖量电费
     */
    private Double jianliangBefore;

    /**
     * 优化前需量电费
     */
    private Double xuliangBefore;

    /**
     * 优化后峰量电费
     */
    private Double fengliangAfter;

    /**
     * 优化后谷量电费
     */
    private Double guliangAfter;

    /**
     * 优化后尖量电费
     */
    private Double jianliangAfter;

    /**
     * 优化后需量电费
     */
    private Double xuliangAfter;

    private static final long serialVersionUID = 1L;
}