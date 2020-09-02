package com.example.demo.dao;

import com.example.demo.entity.Company;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyDao {
    int insert(Company record);

    int insertSelective(Company record);

    List<Company> getCompany();
}