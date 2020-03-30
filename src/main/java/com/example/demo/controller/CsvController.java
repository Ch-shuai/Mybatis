package com.example.demo.controller;

import com.example.demo.entity.CsvDate;
import com.example.demo.entity.TestElectric;
import com.example.demo.service.CsvService;
import com.example.demo.utils.CSVUtils;
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
 *      排序过后的数据，时间最接近现在 的在list最前面
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
        List<CsvDate> csvDateList = CSVUtils.loadDate(srcPath, separator);
        TestElectric testElectric = csvService.getDayElectric(csvDateList);
        return testElectric;
    }
    /**
     * 输入一个日期获得本月的数据
     */
    @GetMapping("/sortList")
    public void sortList(String date) throws ParseException, IOException {
        String srcPath = "C:\\Users\\bjkf0\\Documents\\WeChat Files\\wxid_piv5b666a92f22\\FileStorage\\File\\2020-03\\106_A(1).csv";
        String separator = ",";
        List<CsvDate> csvDatas = CSVUtils.loadDate(srcPath, separator);
        csvService.sortList(csvDatas,date);
    }
}
