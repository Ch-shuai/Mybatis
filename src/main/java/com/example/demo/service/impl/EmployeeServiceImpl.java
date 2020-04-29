package com.example.demo.service.impl;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 2020/4/28
 *
 * @author wuzhanhao
 * <p>
 * description:
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public ArrayList<Employee> getEmployeeList() {
        ArrayList<Employee> employeeArrayList = employeeDao.getList();
        return employeeArrayList;
    }


}
