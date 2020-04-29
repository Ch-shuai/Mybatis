package com.example.demo.dao;

import com.example.demo.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface EmployeeDao {

    Employee selectByName(String username);

    ArrayList<Employee> getList();
}
