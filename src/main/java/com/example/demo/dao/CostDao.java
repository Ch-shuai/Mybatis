package com.example.demo.dao;

import com.example.demo.entity.Cost;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CostDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Cost record);

    int insertSelective(Cost record);

    Cost selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cost record);

    int updateByPrimaryKey(Cost record);

    Cost getCost();
}