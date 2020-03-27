package com.example.demo.service.impl;

import com.example.demo.entity.TestElectric;
import com.example.demo.entity.csvDate;
import com.example.demo.service.CsvService;
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
    public TestElectric getDayElectric(List<csvDate> csvDates) throws ParseException {
        TestElectric testElectric = new TestElectric();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 生效时间
        Date effectivetime = simpleDateFormat.parse("2018-1-1 00:00:00");
        Calendar beginTime = Calendar.getInstance();
        beginTime.setTime(effectivetime);
        // 失效时间
        Date invalidtime = simpleDateFormat.parse("2018-1-1 23:45:00");
        Calendar endTime = Calendar.getInstance();
        endTime.setTime(invalidtime);
        //对比时间
        Calendar estimateTime  = Calendar.getInstance();
        List<csvDate> adaptDate = new ArrayList<>();
        for (csvDate csvDateMessage : csvDates) {
            String date = csvDateMessage.getDate();
            Date csvTime = simpleDateFormat.parse(date);
            estimateTime.setTime(csvTime);
            if (estimateTime.after(beginTime) && estimateTime.before(endTime)) {
                adaptDate.add(csvDateMessage);
            }
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


}
