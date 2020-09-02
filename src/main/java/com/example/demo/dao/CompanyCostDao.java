package com.example.demo.dao;

import com.example.demo.entity.CompanyCost;
import com.example.demo.entity.Cost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CompanyCostDao {
    int insert(CompanyCost record);

    void insertByCost(@Param(value = "cost") Cost cost);

    void insertList(@Param(value = "companyCostList") List<CompanyCost> companyCostList);
}