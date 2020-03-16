package com.example.demo.service.impl;

import com.example.demo.dao.MaterialDao;
import com.example.demo.entity.po.Material;
import com.example.demo.service.MaterialService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 2020/3/8
 *
 * @author Ch-shuai
 * @Description
 */
@Service
public class MaterialServiceImpl implements MaterialService {

    private final MaterialDao materialDao;

    @Autowired
    public MaterialServiceImpl(MaterialDao materialDao) {
        this.materialDao = materialDao;
    }

    @Override
    public List<Material> getData() {
        List<Material> materialList  = materialDao.getList();
        return materialList;
    }

    @Override
    public Map<Integer, Object> getMap() {
        Map<Integer, Object> map = materialDao.getMap();

        for(Integer key : map.keySet()){
            Material material  = (Material) map.get(key);
            String name = material.getName();
            System.out.println(key+":"+name);
        }
        return map;
    }

}
