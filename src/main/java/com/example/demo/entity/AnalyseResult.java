package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 分析之后的结果，
 *      AnalyseResult-->分析之后的结果
 */
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class AnalyseResult {

    //户号
    private Long id;
    //公司名称
    private String name;
    //计价方式
    private String calculateWay;
    //行业
    private String industry;
    //储能单价
    private Double energyPrice;
    //储能容量
    private Double energyCapacity;
    //储能总成本
    private Double energySaveCost;
    //需量电费收益
    private Double energyCost;
    //削峰填谷收益
    private Double energyFillCost;
    //投资最低回报率
    private Double returnRateMin;
    //投资最高回报率
    private Double returnRateMax;
    //回报周期
    private Double returnTime;

    @Override
    public String toString() {
        return "AnalyseResult{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", calculateWay='" + calculateWay + '\'' +
                ", industry='" + industry + '\'' +
                ", energyPrice=" + energyPrice +
                ", energyCapacity=" + energyCapacity +
                ", energySaveCost=" + energySaveCost +
                ", energyCost=" + energyCost +
                ", energyFillCost=" + energyFillCost +
                ", returnRateMin=" + returnRateMin +
                ", returnRateMax=" + returnRateMax +
                ", returnTime=" + returnTime +
                '}';
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

    public Double getEnergyPrice() {
        return energyPrice;
    }

    public void setEnergyPrice(Double energyPrice) {
        this.energyPrice = energyPrice;
    }

    public Double getEnergyCapacity() {
        return energyCapacity;
    }

    public void setEnergyCapacity(Double energyCapacity) {
        this.energyCapacity = energyCapacity;
    }

    public Double getEnergySaveCost() {
        return energySaveCost;
    }

    public void setEnergySaveCost(Double energySaveCost) {
        this.energySaveCost = energySaveCost;
    }

    public Double getEnergyCost() {
        return energyCost;
    }

    public void setEnergyCost(Double energyCost) {
        this.energyCost = energyCost;
    }

    public Double getEnergyFillCost() {
        return energyFillCost;
    }

    public void setEnergyFillCost(Double energyFillCost) {
        this.energyFillCost = energyFillCost;
    }

    public Double getReturnRateMin() {
        return returnRateMin;
    }

    public void setReturnRateMin(Double returnRateMin) {
        this.returnRateMin = returnRateMin;
    }

    public Double getReturnRateMax() {
        return returnRateMax;
    }

    public void setReturnRateMax(Double returnRateMax) {
        this.returnRateMax = returnRateMax;
    }

    public Double getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Double returnTime) {
        this.returnTime = returnTime;
    }

    public AnalyseResult() {
    }

    public AnalyseResult(Long id, String name, String calculateWay, String industry, Double energyPrice, Double energyCapacity, Double energySaveCost, Double energyCost, Double energyFillCost, Double returnRateMin, Double returnRateMax, Double returnTime) {
        this.id = id;
        this.name = name;
        this.calculateWay = calculateWay;
        this.industry = industry;
        this.energyPrice = energyPrice;
        this.energyCapacity = energyCapacity;
        this.energySaveCost = energySaveCost;
        this.energyCost = energyCost;
        this.energyFillCost = energyFillCost;
        this.returnRateMin = returnRateMin;
        this.returnRateMax = returnRateMax;
        this.returnTime = returnTime;
    }
}
