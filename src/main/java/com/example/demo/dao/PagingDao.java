package com.example.demo.dao;

import com.example.demo.entity.po.Material;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 2020/3/9
 *
 * @author wuzhanhao
 */
@Mapper
public interface PagingDao {
    List<Material> findByPage(Map<String, Object> param);

    Long getCount();

    List<Material> getDataList();

}
