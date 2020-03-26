package com.example.demo.service;

import com.example.demo.entity.po.Material;

import java.util.List;
import java.util.Map;

/**
 * 2020/3/8
 *
 * @author Ch-shuai
 * @Description
 */
public interface MaterialService {
    List<Material> getData();

    Map<Integer, Object> getMap();


}
