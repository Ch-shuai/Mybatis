package com.example.demo.utils;

import com.example.demo.entity.csvDate;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import joinery.DataFrame;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 2020/3/26
 *
 * @author Ch-shuai
 * @Description
 */
public class CsvUtils {

    /**
     * 将CSV数据存储到Read,   GBK编码
     * @return
     */
    public static List<csvDate> loadDate(String srcPath, String separator) throws IOException {


        ArrayList<csvDate> csvDateList = new ArrayList<>();
        DataFrame<Object> dataFrame = DataFrame.readCsv(srcPath, separator);
        //设置读入的时候编码格式，CSVWriter.DEFAULT_SEPARATOR设置","分割
        try {
            InputStreamReader is = new InputStreamReader(new FileInputStream(new File(srcPath)), "GBK");
            //将CSV文件转换为Bean对象
            CSVParser csvParser = new CSVParserBuilder().withSeparator('\t').build();
            CSVReader reader = new CSVReaderBuilder(is).withCSVParser(csvParser).build();
            //除去第一行
            String[] strings = reader.readNext();
            //读取下面的信息
            List<String[]> readList = reader.readAll();
            for (int i = 0; i <= readList.size() - 1; i++) {
                String[] strings1 = readList.get(i);
                csvDate csvDate = new csvDate();
                csvDate.setDate(strings1[0]);
                String s = strings1[1];
                String number = s.replace(",", "");
                csvDate.setNumber(number);
                csvDateList.add(csvDate);
            }
        } catch (
            UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return csvDateList;
    }
}
