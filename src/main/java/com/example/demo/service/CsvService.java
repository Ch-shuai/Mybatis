package com.example.demo.service;

import com.example.demo.entity.TestElectric;
import com.example.demo.entity.csvDate;

import java.text.ParseException;
import java.util.List;

/**
 * 2020/3/26
 *
 * @author Ch-shuai
 * @Description
 */
public interface CsvService {
    TestElectric getDayElectric(List<csvDate> csvDatas) throws ParseException;
}
