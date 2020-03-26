package com.example.demo.controller;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import joinery.DataFrame;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.sql.Array;
import java.text.SimpleDateFormat;
import java.util.*;

import static jdk.nashorn.internal.objects.Global.println;

/**
 * 2020/3/26
 *
 * @author wuzhanhao
 * <p>
 * description:
 */
@RestController
public class CsvController {
    public static void main(String[] args) throws IOException {
        String srcPath = "C:\\Users\\bjkf0\\Documents\\WeChat Files\\wxid_piv5b666a92f22\\FileStorage\\File\\2020-03\\106_A.csv";
        String separator = ",";
        DataFrame<Object> dataFrame = DataFrame.readCsv(srcPath, separator);

        ListIterator<Map<Object, Object>> itermap = dataFrame.itermap();
    }
}
