package com.example.demo.dao;

import com.example.demo.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeDao {

    Employee selectByName(String username);
}
