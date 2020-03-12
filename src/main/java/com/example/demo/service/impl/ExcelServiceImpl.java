package com.example.demo.service.impl;

import com.example.demo.dao.MaterialDao;
import com.example.demo.entity.po.Material;
import com.example.demo.service.ExcelService;
import com.example.demo.utils.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 2020/3/10
 *
 * @author wuzhanhao
 * <p>
 * description:
 */
@Service
public class ExcelServiceImpl implements ExcelService {
    private final MaterialDao materialDao;

    @Autowired
    public ExcelServiceImpl(MaterialDao materialDao) {
        this.materialDao = materialDao;
    }


    @Override
    public void exportExcel(HttpServletResponse response) {
        Map<Integer, Object> map = materialDao.getMap();
        List<Material> list = materialDao.getList();
        ExcelUtils.export(response,list);

    }
}
