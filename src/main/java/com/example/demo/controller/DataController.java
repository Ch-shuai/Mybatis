package com.example.demo.controller;

import com.example.demo.entity.Company;
import com.example.demo.entity.Cost;
import com.example.demo.service.DataService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sqlite.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @author wuzhanhao
 * 将多条数据用多线程去修改，根据两张表里面的数据生成一条新的数据，并且存储到数据库中
 */
@RestController
@RequestMapping("/data")
public class DataController {

    private final DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @RequestMapping("")
    @ApiOperation(value = "修改数据" , notes = "修改数据库里的数据" , httpMethod = "GET")
    public void modifyData() {
        Date startTime = new Date();
        System.out.println("开始执行的时间-----"+startTime);
        List<Company> companyList = dataService.getCompany();
        Cost cost = dataService.getCost();
        dataService.modifyData(companyList,cost);
        Date endTime = new Date();
        System.out.println("结束执行的时间-----"+endTime);
    }

    @RequestMapping("test")
    public void modifyData2() {
        Date startTime = new Date();
        System.out.println("开始执行的时间-----"+startTime);
        Cost cost = dataService.getCost();
        dataService.modifyData2(cost);
        Date endTime = new Date();
        System.out.println("结束执行的时间-----"+endTime);
    }


}
