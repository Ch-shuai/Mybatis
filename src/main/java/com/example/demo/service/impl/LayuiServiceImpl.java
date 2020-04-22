package com.example.demo.service.impl;

import com.example.demo.dao.LayuiDao;
import com.example.demo.entity.article;
import com.example.demo.service.LayuiService;
import com.example.demo.web.result.Result;
import com.sun.org.apache.xml.internal.utils.StringToStringTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 2020/4/7
 *
 * @author wuzhanhao
 * <p>
 * description:
 */

@Service
public class LayuiServiceImpl implements LayuiService {

    private final LayuiDao layuiDao;

    @Autowired
    public LayuiServiceImpl(LayuiDao layuiDao) {
        this.layuiDao = layuiDao;
    }

    @Override
    public Result managePost() {
        return null;
    }

}
