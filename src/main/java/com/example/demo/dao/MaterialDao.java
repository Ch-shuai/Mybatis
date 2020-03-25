package com.example.demo.dao;

import com.example.demo.entity.TestElectric;
import com.example.demo.entity.po.Material;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * 2020/3/8
 *
 * @author Ch-shuai
 * @Description
 */

@Mapper
public interface MaterialDao extends BaseMapper<Material> {

    List<Material> getList();

    @MapKey("id")
    Map<Integer, Object> getMap();

    void addarr(TestElectric testElectric);
}
