package com.example.demo.dao;

import com.example.demo.entity.po.Material;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 2020/3/8
 *
 * @author Ch-shuai
 * @Description
 */

@Mapper
public interface MaterialDao {

    List<Material> getList();

    @MapKey("id")
    Map<Integer, Object> getMap();
}
