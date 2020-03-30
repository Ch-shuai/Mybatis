package com.example.demo.service;

import com.example.demo.entity.CsvDate;
import com.example.demo.entity.TestElectric;

import java.text.ParseException;
import java.util.List;

/**
 * 2020/3/26
 *
 * @author Ch-shuai
 * @Description
 */
public interface CsvService {
    TestElectric getDayElectric(List<CsvDate> csvDatas) throws ParseException;

    void sortList(List<CsvDate> csvDatas, String date) throws ParseException;
}
