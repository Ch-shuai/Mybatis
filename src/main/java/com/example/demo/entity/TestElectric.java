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

    //最大用电量
    private Long MaxElectric;
    //最小用电量
    private Long MinElectric;
    //总共用电量
    private Long SumElectric;
    //平均用电量
    private Long AvgElectric;

}
