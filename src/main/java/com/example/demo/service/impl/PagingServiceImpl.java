package com.example.demo.service.impl;

import com.example.demo.dao.PagingDao;
import com.example.demo.entity.po.Material;
import com.example.demo.service.PagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 2020/3/9
 *
 * @author wuzhanhao
 */

@Service
public class PagingServiceImpl implements PagingService {

    private final PagingDao pagingDao;

    @Autowired
    public PagingServiceImpl(PagingDao pagingDao) {
        this.pagingDao = pagingDao;
    }


    @Override
    public List<Material> getDataByPage(Map<String, Object> param) {
        List<Material> materialList = pagingDao.findByPage(param);
        return materialList;
    }

    @Override
    public Long count() {
        return pagingDao.getCount();
    }

    @Override
    public List<Material> getDataList(Integer page, Integer size) {
        List<Material> materialList = pagingDao.getDataList();
        int firstData = (page-1) * size;
        int lastData = page * size;
        return materialList.subList(firstData,lastData);
    }

}
