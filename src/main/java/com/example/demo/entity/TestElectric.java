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

    private Long MaxElectric;
    private Long MinElectric;
    private Long SumElectric;
    private Long AvgElectric;

}
