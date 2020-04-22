package com.example.demo.web.page;

import java.io.Serializable;

/**
 * @author wuzhanhao
 */
public class TestData implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long rows;
    //户号
    private Long id;
    //公司名称
    private String name;
    //计价方式
    private String calculateWay;
    //行业
    private String industry;
    //储能单价
    private Long energyPrice;
    //储能容量
    private Long energyCapacity;
    //储能总成本
    private Long energySaveCost;
    //需量电费收益
    private Long energyCost;
    //削峰填谷收益
    private Long energyFillCost;
    //投资回报率
    private Double returnRate;
    //回报周期
    private Long returnTime;

    @Override
    public String toString() {
        return "TestData{" +
                "rows=" + rows +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", calculateWay='" + calculateWay + '\'' +
                ", industry='" + industry + '\'' +
                ", energyPrice=" + energyPrice +
                ", energyCapacity=" + energyCapacity +
                ", energySaveCost=" + energySaveCost +
                ", energyCost=" + energyCost +
                ", energyFillCost=" + energyFillCost +
                ", returnRate=" + returnRate +
                ", returnTime=" + returnTime +
                '}';
    }

    public TestData() {
    }

    public TestData(Long rows, Long id, String name, String calculateWay, String industry, Long energyPrice, Long energyCapacity, Long energySaveCost, Long energyCost, Long energyFillCost, Double returnRate, Long returnTime) {
        this.rows = rows;
        this.id = id;
        this.name = name;
        this.calculateWay = calculateWay;
        this.industry = industry;
        this.energyPrice = energyPrice;
        this.energyCapacity = energyCapacity;
        this.energySaveCost = energySaveCost;
        this.energyCost = energyCost;
        this.energyFillCost = energyFillCost;
        this.returnRate = returnRate;
        this.returnTime = returnTime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getRows() {
        return rows;
    }

    public void setRows(Long rows) {
        this.rows = rows;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCalculateWay() {
        return calculateWay;
    }

    public void setCalculateWay(String calculateWay) {
        this.calculateWay = calculateWay;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Long getEnergyPrice() {
        return energyPrice;
    }

    public void setEnergyPrice(Long energyPrice) {
        this.energyPrice = energyPrice;
    }

    public Long getEnergyCapacity() {
        return energyCapacity;
    }

    public void setEnergyCapacity(Long energyCapacity) {
        this.energyCapacity = energyCapacity;
    }

    public Long getEnergySaveCost() {
        return energySaveCost;
    }

    public void setEnergySaveCost(Long energySaveCost) {
        this.energySaveCost = energySaveCost;
    }

    public Long getEnergyCost() {
        return energyCost;
    }

    public void setEnergyCost(Long energyCost) {
        this.energyCost = energyCost;
    }

    public Long getEnergyFillCost() {
        return energyFillCost;
    }

    public void setEnergyFillCost(Long energyFillCost) {
        this.energyFillCost = energyFillCost;
    }

    public Double getReturnRate() {
        return returnRate;
    }

    public void setReturnRate(Double returnRate) {
        this.returnRate = returnRate;
    }

    public Long getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Long returnTime) {
        this.returnTime = returnTime;
    }
}
