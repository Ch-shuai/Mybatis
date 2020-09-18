package com.example.demo.controller;

import com.example.demo.entity.Employee;

import com.example.demo.entity.Page1;
import com.example.demo.service.EmployeeService;
import com.example.demo.util.PagedGridResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
@Api(value = "测试用户分页" ,tags = {"测试分页tags"})
public class EmplyeeController {

    @Autowired
    EmployeeService employeeService;

    /**
     * 使用分页插件
     * @param page1
     * @return
     */
    @GetMapping("")
    public PagedGridResult getEmployeeList(@RequestBody Page1 page1){
        Map<String, Object> data = new HashMap<>();
        int pageNo = page1.getPage();
        int pageSize = page1.getSize();
        Page page = PageHelper.startPage(pageNo,pageSize,true);
        ArrayList<Employee> employeeArrayList = employeeService.getEmployeeList();
        return EmplyeeController.setterPagedGrid(employeeArrayList, pageNo);
    }

    @PostMapping("/test")
    public void getEmployee(){
        ArrayList<Employee> employeeList = employeeService.getEmployeeList();
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
    }

    @Scheduled(cron = "0 * * * * *")
    public void getEmployeeByScheduled(){
        ArrayList<Employee> employeeList = employeeService.getEmployeeList();
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
    }

    private static PagedGridResult setterPagedGrid(List<?> list, Integer page) {
        PageInfo<?> pageList = new PageInfo<>(list);
        PagedGridResult grid = new PagedGridResult();
        grid.setPage(page);
        grid.setRows(list);
        grid.setTotal(pageList.getPages());
        grid.setRecords(pageList.getTotal());
        return grid;
    }
}
