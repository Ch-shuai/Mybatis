package com.example.demo.entity;

import lombok.Data;


/**
 * 2020/3/25
 *
 * @author wuzhanhao
 * <p>
 * description:
 */
@Data
public class TestElectric {

    private int id;
    private Integer MaxElectric;
    private Integer MinElectric;
    private Integer SumElectric;


    public TestElectric(int id, Integer maxElectric, Integer minElectric, Integer sumElectric) {
        this.id = id;
        MaxElectric = maxElectric;
        MinElectric = minElectric;
        SumElectric = sumElectric;
    }
}
