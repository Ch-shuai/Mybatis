package com.example.demo.utils;

import java.nio.charset.Charset;

/**
 * 2020/3/10
 *
 * @author wuzhanhao
 * <p>
 * description:
 *
 *      判断当前string的编码格式
 */
public class Encoding {

    public static String getEncoding(String str) {
        String encode;

        encode = "UTF-16";
        try
        {
            if(str.equals(new String(str.getBytes(), encode))) {
            return encode;
        }
        }
        catch(Exception ex) {}

        encode = "ASCII";
        try
        {
            if(str.equals(new String(str.getBytes(), encode))) {
            return "字符串<< " + str + " >>中仅由数字和英文字母组成，无法识别其编码格式";
        }
        }
        catch(Exception ex) {}

        encode = "ISO-8859-1";
        try
        {
            if(str.equals(new String(str.getBytes(), encode))) {
            return encode;
        }
        }
        catch(Exception ex) {}
        encode = "GB2312";
        try
        {
            if(str.equals(new String(str.getBytes(), encode))) {
            return encode;
        }
        }
        catch(Exception ex) {}

        encode = "UTF-8";
        try
        {
            if(str.equals(new String(str.getBytes(), encode))) {
            return encode;
        }
        }
        catch(Exception ex) {}

        return "未识别编码格式";
    }

}
