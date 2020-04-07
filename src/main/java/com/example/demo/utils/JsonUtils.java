package com.example.demo.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.apache.poi.hssf.record.DVALRecord;
import springfox.documentation.spring.web.json.Json;

/**
 * 2020/3/10
 *
 * @author wuzhanhao
 * <p>
 * description:
 *      Object-->JsonString
 *      String-->Object
 *      Json---->List
 */

public class JsonUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static String objToJSONString(Object object){
        return null;
    }
}
