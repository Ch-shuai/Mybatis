package com.example.demo.service.impl;

import com.example.demo.entity.TestElectric;
import com.example.demo.entity.csvDate;
import com.example.demo.service.CsvService;
import com.example.demo.utils.CSVUtils;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 2020/3/26
 *
 * @author Ch-shuai
 * @Description
 */
@Service
public class CsvServiceImpl implements CsvService {

    @Override
    public TestElectric getDayElectric(List<csvDate> csvDatas) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        TestElectric testElectric = new TestElectric();
        // 生效时间
        Date effectivetime = simpleDateFormat.parse("2018-1-1 00:00:00");
        Calendar beginTime = Calendar.getInstance();
        beginTime.setTime(effectivetime);
        // 失效时间
        Date invalidtime = simpleDateFormat.parse("2018-1-1 23:59:00");
        Calendar endTime = Calendar.getInstance();
        endTime.setTime(invalidtime);
        //对比时间
        Calendar estimateTime  = Calendar.getInstance();
        List<csvDate> adaptDate = new ArrayList<>();
        for (csvDate csvDateMessage : csvDatas) {
            Date csvDateMessageDate = csvDateMessage.getDate();
            estimateTime.setTime(csvDateMessageDate);
            if (estimateTime.after(beginTime) && estimateTime.before(endTime)) {
                adaptDate.add(csvDateMessage);
            }
        }
        for(int i = 0;i<adaptDate.size()-1;i++){
            System.out.println("这是第" + i + "的数据" + adaptDate.get(i));
        }

        csvDate csvDateMax = adaptDate.stream().max(Comparator.comparing(com.example.demo.entity.csvDate::getNumber)).get();
        csvDate csvDateMin = adaptDate.stream().min(Comparator.comparing(com.example.demo.entity.csvDate::getNumber)).get();
        Double numberSum = 0D;
        for(int i = 0 ; i<= adaptDate.size()-1;i++){
            csvDate csvDate = adaptDate.get(i);
            Double eletricNumber = Double.valueOf(csvDate.getNumber());
            numberSum += eletricNumber;
        }
        Double numberAvg = numberSum / Double.valueOf(adaptDate.size() );
        testElectric.setMaxElectric(Double.valueOf(csvDateMax.getNumber()));
        testElectric.setMinElectric(Double.valueOf(csvDateMin.getNumber()));
        testElectric.setSumElectric(numberSum);
        testElectric.setAvgElectric(numberAvg);
        return testElectric ;

    }

    private List<csvDate> sortList(List<csvDate> csvDatas) throws ParseException {

        String titles = "date,number";
        String keys = "date,string";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //距离现在日期最近的数据
        csvDate newData = csvDatas.get(0);
        Date newDatadate = newData.getDate();
        Calendar newInstance = Calendar.getInstance();
        newInstance.setTime(newDatadate);
        int newYear = newInstance.get(Calendar.YEAR);
        System.out.println("距离现在日期最近的数据newYear" + newDatadate + "newYear" + newYear);

        //距离现在日期最远的数据
        csvDate oldData = csvDatas.get(csvDatas.size()-1);
        Calendar oldInstance = Calendar.getInstance();
        oldInstance.setTime(oldData.getDate());
        int oldYear = oldInstance.get(Calendar.YEAR);
        System.out.println("距离现在日期最远的数据newYear" + oldData.getDate() + "newYear" + newYear);

        int year = newYear-oldYear;
        System.out.println(year);
        for (int i = 0;i<=year;i++){
            if (i == 0){
                System.out.println("这个list记载的数据是同一年");
            }
            List<csvDate> nextYearList = new ArrayList<>();
            int nextYear = oldYear + i;
            for (csvDate csvData : csvDatas) {
                nextYearList.add(csvData);
                CSVUtils.createCSVFile(nextYearList,)
            }
        }
        return null;
    }

}
