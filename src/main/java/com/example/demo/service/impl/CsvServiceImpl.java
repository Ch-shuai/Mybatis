package com.example.demo.service.impl;

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
    public void getDayElectric(List<csvDate> csvDates) throws ParseException {
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

        for (csvDate csvDate : csvDates) {
            String date = csvDate.getDate();
            Date csvTime = simpleDateFormat.parse(date);
            estimateTime.setTime(csvTime);
            List<com.example.demo.entity.csvDate> adaptDate = new ArrayList<>();
            if (estimateTime.after(beginTime) && estimateTime.before(endTime)) {
                adaptDate.add(csvDate);

            }
        }

    }


}
