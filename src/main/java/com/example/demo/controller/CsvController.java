package com.example.demo.controller;

import com.example.demo.service.CsvService;
import com.example.demo.util.CSVUtils;
import io.swagger.annotations.Api;
import joinery.DataFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

/**
 * 2020/3/26
 *
 * @author wuzhanhao
 * <p>
 * description:
 *      排序过后的数据，时间最接近现在 的在list最前面
 */
@RestController
@RequestMapping("csv")
@Api(description = "CSV文件格式排序")
public class CsvController {

    private final CsvService csvService;

    @Autowired
    public CsvController(CsvService csvService) {
        this.csvService = csvService;
    }

    @GetMapping("/getDayElectric")
    public void getDayElectric(){
        String src = "C:\\Users\\bjkf0\\Documents\\WeChat Files\\wxid_piv5b666a92f22\\FileStorage\\File\\2020-03\\106_A(1).csv";
        CSVUtils.getDateFrame(src);
    }

    @GetMapping("test")
    public void testTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date parse = simpleDateFormat.parse("2019-05-01 00:00:00");
            Calendar instance = Calendar.getInstance();
            instance.setTime(parse);
            int year = instance.get(Calendar.YEAR);
            int date = instance.get(Calendar.DATE);
            int month = instance.get(Calendar.MONTH);
            int week = instance.get(Calendar.WEEK_OF_YEAR);

            System.out.println("年+" + year + "月+" + month + "日+" + date + "周" + week);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DataFrame<Object> df = new DataFrame<Object>(Collections.emptyList(),
                Arrays.asList("name", "value"),
                Arrays.asList(Arrays.asList("alpha", "bravo", "charlie"),
                Arrays.asList(10, 20, 30)));
        System.out.println(df);
    }

}
