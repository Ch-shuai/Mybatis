package com.example.demo.utils;
import joinery.DataFrame;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletResponse;


/**
 * 文件操作
 * @author 12825
 * @Decription:
 *          CSV工具类
 */
public class CSVUtils {

    /**
     * 获取dateframe数据
     * @param src
     */
    public static void getDateFrame(String src) {
        try {

            DataFrame<Object> dataFrame = DataFrame.readCsv(src).retain("date", "number").groupBy(row->function(row));
            List<Object> date = dataFrame.col("date");
            System.out.println(date.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Integer function(List<Object> row) {
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Integer day = null;
        try {
            instance.setTime(simpleDateFormat.parse(row.get(1).toString()));
            day = instance.get(Calendar.DATE);
            System.out.println(day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return day;
    }

    /**
     * 功能说明：获取UTF-8编码文本文件开头的BOM签名。
     * BOM(Byte Order Mark)，是UTF编码方案里用于标识编码的标准标记。例：接收者收到以EF BB BF开头的字节流，就知道是UTF-8编码。
     * @return UTF-8编码文本文件开头的BOM签名
     */
    public static String getBOM() {

        byte b[] = {(byte)0xEF, (byte)0xBB, (byte)0xBF};
        return new String(b);
    }

    /**
     * 生成CVS文件
     * @param exportData
     *       源数据List
     * @param map
     *       csv文件的列表头map
     * @param outPutPath
     *       文件路径
     * @param fileName
     *       文件名称
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static File createCSVFile(List exportData, LinkedHashMap map, String outPutPath,
                                     String fileName) {
        File csvFile = null;
        BufferedWriter csvFileOutputStream = null;
        try {
            File file = new File(outPutPath);
            if (!file.exists()) {
                file.mkdirs();
            }
            //定义文件名格式并创建
            csvFile =new File(outPutPath+fileName+".csv");
            file.createNewFile();
            // UTF-8使正确读取分隔符","
            //如果生产文件乱码，windows下用gbk，linux用UTF-8
            csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(
                    csvFile), "UTF-8"), 1024);

            //写入前段字节流，防止乱码
            csvFileOutputStream.write(getBOM());
            // 写入文件头部
            for (Iterator propertyIterator = map.entrySet().iterator(); propertyIterator.hasNext();) {
                java.util.Map.Entry propertyEntry = (java.util.Map.Entry) propertyIterator.next();
                csvFileOutputStream.write((String) propertyEntry.getValue() != null ? (String) propertyEntry.getValue() : "" );
                if (propertyIterator.hasNext()) {
                    csvFileOutputStream.write(",");
                }
            }
            csvFileOutputStream.newLine();
            // 写入文件内容
            for (Iterator iterator = exportData.iterator(); iterator.hasNext();) {
                Object row = (Object) iterator.next();
                for (Iterator propertyIterator = map.entrySet().iterator(); propertyIterator
                        .hasNext();) {
                    java.util.Map.Entry propertyEntry = (java.util.Map.Entry) propertyIterator
                            .next();
                    String str=row!=null?((String)((Map)row).get( propertyEntry.getKey())):"";

                    if(StringUtils.isEmpty(str)){
                        str="";
                    }else{
                        str=str.replaceAll("\"","\"\"");
                        if(str.indexOf(",")>=0){
                            str="\""+str+"\"";
                        }
                    }
                    csvFileOutputStream.write(str);
                    if (propertyIterator.hasNext()) {
                        csvFileOutputStream.write(",");
                    }
                }
                if (iterator.hasNext()) {
                    csvFileOutputStream.newLine();
                }
            }
            csvFileOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                csvFileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return csvFile;
    }

    /**
     *     生成并下载csv文件
     * @param response
     * @param exportData
     * @param map
     * @param outPutPath
     * @param fileName
     * @throws IOException
     */
    @SuppressWarnings("rawtypes")
    public static void exportDataFile(HttpServletResponse response,List exportData, LinkedHashMap map, String outPutPath,String fileName) throws IOException{
        File csvFile = null;
        BufferedWriter csvFileOutputStream = null;
        try {
            File file = new File(outPutPath);
            if (!file.exists()) {
                file.mkdirs();
            }
            //定义文件名格式并创建
            csvFile =new File(outPutPath+fileName+".csv");
            if(csvFile.exists()){
                csvFile.delete();
            }
            csvFile.createNewFile();
            // UTF-8使正确读取分隔符","
            //如果生产文件乱码，windows下用gbk，linux用UTF-8
            csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "UTF-8"), 1024);
            //写入前段字节流，防止乱码
            csvFileOutputStream.write(getBOM());
            // 写入文件头部
            for (Iterator propertyIterator = map.entrySet().iterator(); propertyIterator.hasNext();) {
                java.util.Map.Entry propertyEntry = (java.util.Map.Entry) propertyIterator.next();
                csvFileOutputStream.write((String) propertyEntry.getValue() != null ? (String) propertyEntry.getValue() : "" );
                if (propertyIterator.hasNext()) {
                    csvFileOutputStream.write(",");
                }
            }
            csvFileOutputStream.newLine();
            // 写入文件内容
            for (Iterator iterator = exportData.iterator(); iterator.hasNext();) {
                Object row = (Object) iterator.next();
                for (Iterator propertyIterator = map.entrySet().iterator(); propertyIterator
                        .hasNext();) {
                    java.util.Map.Entry propertyEntry = (java.util.Map.Entry) propertyIterator
                            .next();
                    String str=row!=null?((String)((Map)row).get( propertyEntry.getKey())):"";
                    if(StringUtils.isEmpty(str)){
                        str="";
                    }else{
                        str=str.replaceAll("\"","\"\"");
                        if(str.indexOf(",")>=0){
                            str="\""+str+"\"";
                        }
                    }
                    csvFileOutputStream.write(str);
                    if (propertyIterator.hasNext()) {
                        csvFileOutputStream.write(",");
                    }
                }
                if (iterator.hasNext()) {
                    csvFileOutputStream.newLine();
                }
            }
            csvFileOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                csvFileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        InputStream in = null;
        try {
            in = new FileInputStream(outPutPath+fileName+".csv");
            int len = 0;
            byte[] buffer = new byte[1024];

            OutputStream out = response.getOutputStream();
            response.reset();

            response.setContentType("application/csv;charset=UTF-8");
            response.setHeader("Content-Disposition","attachment; filename=" + URLEncoder.encode(fileName+".csv", "UTF-8"));
            response.setCharacterEncoding("UTF-8");
            while ((len = in.read(buffer)) > 0) {
                out.write(new byte[] { (byte) 0xEF, (byte) 0xBB, (byte) 0xBF });
                out.write(buffer, 0, len);
            }
            out.close();
        } catch (FileNotFoundException e) {
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    /**
     * 获取当前月的第一天
     * @param month
     * @return
     */
    public static String getFirstDayOfMonth(int month) {
        Calendar cal = Calendar.getInstance();
        // 设置月份
        cal.set(Calendar.MONTH, month - 1);
        // 获取某月最小天数
        int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        // 设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        // 格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String firstDayOfMonth = sdf.format(cal.getTime())+" 00:00:00";
        return firstDayOfMonth;
    }
    /**
     * 获得该月最后一天
     *
     * @param month
     * @return
     */
    public static String getLastDayOfMonth(int month) {
        Calendar cal = Calendar.getInstance();
        // 设置月份
        cal.set(Calendar.MONTH, month - 1);
        // 获取某月最大天数
        int lastDay=0;
        //2月的平年瑞年天数
        if(month==2) {
            lastDay = cal.getLeastMaximum(Calendar.DAY_OF_MONTH);
        }else {
            lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        }
        // 设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        // 格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String lastDayOfMonth = sdf.format(cal.getTime())+" 23:59:59";
        return lastDayOfMonth;
    }

}
