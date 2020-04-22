package com.example.demo.utils;

import com.example.demo.entity.Employee;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.apache.poi.hssf.record.DVALRecord;
import springfox.documentation.spring.web.json.Json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static String objToJSONString(Object object) {
        try {
            mapper.setSerializationInclusion( JsonInclude.Include.ALWAYS );
            // 如果json中有新增的字段并且是实体类类中不存在的，不报错
            mapper.configure( SerializationFeature.FAIL_ON_EMPTY_BEANS, false );
            return mapper.writeValueAsString( object );
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static <T> T JSONStringToObj(String jsonString, Class<T> T) {
        try {
            // 序列化时候序列所有属性
            mapper.setSerializationInclusion( JsonInclude.Include.ALWAYS );
            // 如果是空对象不抛出异常
            mapper.configure( SerializationFeature.FAIL_ON_EMPTY_BEANS, false );
            return mapper.convertValue( mapper.readTree( jsonString ), T );
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> parseJsonList(String json, Class<T> clazz) {
        try {
            JavaType javaType = getCollectionType( ArrayList.class, clazz);
            return (List<T>) mapper.readValue(json, javaType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param collectionClass 集合类
     * @param elementClasses 集合元素类
     * @return
     * @description 获取泛型的ColloectionType
     * @author paul
     * @date 2017年8月12日 下午2:17:38
     * @update 2017年8月12日 下午2:17:38
     * @version V1.0
     */
    private static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }


}
