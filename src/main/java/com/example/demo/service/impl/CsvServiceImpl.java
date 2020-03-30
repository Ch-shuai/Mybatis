package com.example.demo.service.impl;

import com.example.demo.entity.CsvDate;
import com.example.demo.entity.TestElectric;
import com.example.demo.service.CsvService;
import com.example.demo.utils.CSVUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 2020/3/26
 *
 * @author Ch-shuai
 * @Description
 *      使用Calendar时，月份从0开始计算，所以需要+1
 */
@Service
public class CsvServiceImpl implements CsvService {

    @Override
    public TestElectric getDayElectric(List<CsvDate> csvDatas) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 生效时间
        Date effectivetime = simpleDateFormat.parse("2018-1-1 00:00:00");
        Calendar beginTime = Calendar.getInstance();
        beginTime.setTime(effectivetime);
        // 失效时间
        Date invalidtime = simpleDateFormat.parse("2018-5-1 23:59:00");
        Calendar endTime = Calendar.getInstance();
        endTime.setTime(invalidtime);
        //对比时间
        Calendar estimateTime  = Calendar.getInstance();
        //创建一个空数组
        List<CsvDate> adaptDate = new ArrayList<>();
        for (CsvDate csvDateMessage : csvDatas) {
            Date csvDateMessageDate = csvDateMessage.getDate();
            estimateTime.setTime(csvDateMessageDate);
            if (estimateTime.after(beginTime) && estimateTime.before(endTime)) {
                adaptDate.add(csvDateMessage);
            }
        }

        return getResult(adaptDate);

    }

    @Override
    public void sortList(List<CsvDate> csvDatas, String date) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //距离现在日期最近的数据
        CsvDate newData = csvDatas.get(0);
        Date newDatadate = newData.getDate();
        Calendar newInstance = Calendar.getInstance();
        newInstance.setTime(newDatadate);

        Date parse = simpleDateFormat.parse(date);
        Calendar instance = Calendar.getInstance();
        instance.setTime(parse);
        int month = instance.get(Calendar.MONTH);
        //获取当前月的第一天
        String firstDayOfMonth = CSVUtils.getFirstDayOfMonth(month);
        //获取当前月的最后一天
        String lastDayOfMonth = CSVUtils.getLastDayOfMonth(month);

    }

    /**
     * 根据时间筛选过的list
     * @param adaptDate
     * @return
     */
    private TestElectric getResult(List<CsvDate> adaptDate) {
        TestElectric testElectric = new TestElectric();
        CsvDate csvDateMax = adaptDate.stream().max(Comparator.comparing(CsvDate::getNumber)).get();
        CsvDate csvDateMin = adaptDate.stream().min(Comparator.comparing(CsvDate::getNumber)).get();
        double numberSum = 0D;
        for(int i = 0 ; i<= adaptDate.size()-1;i++){
            CsvDate csvDate = adaptDate.get(i);
            double eletricNumber = Double.parseDouble(csvDate.getNumber());
            numberSum += eletricNumber;
        }
        double numberAvg = numberSum / (double) adaptDate.size();
        double maxNumber = Double.parseDouble(csvDateMax.getNumber());
        double minNumber = Double.parseDouble(csvDateMin.getNumber());

        BigDecimal bigDecimal = new BigDecimal(numberAvg).setScale(2, RoundingMode.HALF_UP);
        double avgDouble = bigDecimal.doubleValue();
        BigDecimal sumDecimal = new BigDecimal(numberSum).setScale(2, RoundingMode.HALF_UP);
        double sumDouble = sumDecimal.doubleValue();
        BigDecimal maxDecimal = new BigDecimal(maxNumber).setScale(2, RoundingMode.HALF_UP);
        double maxDouble = maxDecimal.doubleValue();
        BigDecimal minDecimal = new BigDecimal(minNumber).setScale(2, RoundingMode.HALF_UP);
        double minDouble = sumDecimal.doubleValue();

        testElectric.setMaxElectric(maxDouble);
        testElectric.setMinElectric(minDouble);
        testElectric.setSumElectric(sumDouble);
        testElectric.setAvgElectric(avgDouble);
        return testElectric ;
    }

}
