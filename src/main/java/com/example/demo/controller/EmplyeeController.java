package com.example.demo.controller;

import com.example.demo.entity.Employee;

import com.example.demo.entity.Page1;
import com.example.demo.service.EmployeeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 2020/4/28
 *
 * @author wuzhanhao
 * <p>
 * description:
 *
 *          ******由于pageHelper分页是与线程绑定，所以有时会导致pagehelper分页失败出错
 */
@RequestMapping("/Employee")
@RestController
@Api(description = "测试用户分页")
public class EmplyeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("")
    public Map<String, Object> getEmployeeList(@RequestBody Page1 page1){
        Map<String, Object> data = new HashMap<>();
        int pageNo = page1.getPage();
        int pageSize = page1.getSize();
        Page page = PageHelper.startPage(pageNo,pageSize,true);
        ArrayList<Employee> employeeArrayList = employeeService.getEmployeeList();

        data.put("total", page.getTotal());
        data.put("nowPage", pageNo);
        data.put("data", employeeArrayList);
        return data;
    }

    @PostMapping("/test")
    public void getEmployee(){
        ArrayList<Employee> employeeList = employeeService.getEmployeeList();
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
    }

}
