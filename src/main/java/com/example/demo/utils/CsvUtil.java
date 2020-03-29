package com.example.demo.utils;

import com.example.demo.entity.csvDate;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import joinery.DataFrame;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 2020/3/26
 *
 * @author Ch-shuai
 * @Description
 *      获取到CSV文件将其转化为list
 */
public class CsvUtil {

    /**
     * 将CSV数据存储到Read,   GBK编码
     * @return
     */
    public static List<csvDate> loadDate(String srcPath, String separator) throws IOException {


        ArrayList<csvDate> csvDataList = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //设置读入的时候编码格式，CSVWriter.DEFAULT_SEPARATOR设置","分割
        try {
            InputStreamReader is = new InputStreamReader(new FileInputStream(new File(srcPath)), "GBK");
            //将CSV文件转换为Bean对象
            CSVParser csvParser = new CSVParserBuilder().withSeparator('\t').build();
            CSVReader reader = new CSVReaderBuilder(is).withCSVParser(csvParser).build();
            //除去第一行
            reader.readNext();
            //读取下面的信息
            List<String[]> readList = reader.readAll();
            for (int i = 0; i <= readList.size() - 1; i++) {
                String[] strings1 = readList.get(i);
                csvDate csvDate = new csvDate();
                Date parse = simpleDateFormat.parse(strings1[0]);
                csvDate.setDate(parse);
                String s = strings1[1];
                String number = s.replace(",", "");
                csvDate.setNumber(number);
                csvDataList.add(csvDate);
            }
        } catch (
                UnsupportedEncodingException | ParseException e) {
            e.printStackTrace();
        }
        //排序的结果是
        //这是第0的数据csvDate(date=2018-01-01 23:45:00, number=20.0)
        //这是第1的数据csvDate(date=2018-01-01 23:30:00, number=18.4)
        csvDataList.sort((t1,t2) -> t2.getDate().compareTo(t1.getDate()));
        return csvDataList;
    }


}
