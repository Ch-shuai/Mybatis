package com.example.demo.controller;

import com.example.demo.entity.TestElectric;
import com.example.demo.entity.csvDate;
import com.example.demo.service.CsvService;
import com.example.demo.utils.CsvUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.text.ParseException;
import java.util.*;


/**
 * 2020/3/26
 *
 * @author wuzhanhao
 * <p>
 * description:
 */
@RestController
@RequestMapping("Csv")
public class CsvController {

    private final CsvService csvService;

    @Autowired
    public CsvController(CsvService csvService) {
        this.csvService = csvService;
    }


    /**
     * 按照时间对数据进行分析，
     *     一天中获取最大用电量，最小用电量，平均用电量，总共用电量
     */
    @GetMapping("/getDayElectric")
    public TestElectric getDayElectric() throws IOException, ParseException {
        String srcPath = "C:\\Users\\bjkf0\\Documents\\WeChat Files\\wxid_piv5b666a92f22\\FileStorage\\File\\2020-03\\106_A(1).csv";
        String separator = ",";
        List<csvDate> csvDates = CsvUtils.loadDate(srcPath, separator);
        TestElectric testElectric = csvService.getDayElectric(csvDates);
        return testElectric;
    }

    /**
     * 获取一个月内数据
     *
     */
}
