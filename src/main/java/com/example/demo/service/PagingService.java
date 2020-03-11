package com.example.demo.service;

import com.example.demo.entity.po.Material;

import java.util.List;
import java.util.Map;

/**
 * 2020/3/9
 *
 * @author wuzhanhao
 */

public interface PagingService {
    List<Material> getDataByPage(Map<String, Object> param);

    Long count();

    List<Material> getDataList(Integer page, Integer size);
}
