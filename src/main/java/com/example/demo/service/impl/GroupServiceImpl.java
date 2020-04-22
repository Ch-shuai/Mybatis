package com.example.demo.service.impl;

import com.example.demo.dao.GroupDao;
import com.example.demo.entity.AnalyseResult;
import com.example.demo.entity.Form;
import com.example.demo.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupDao groupDao;

    @Autowired
    public GroupServiceImpl(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public List<AnalyseResult> getForm(Form form) {
        List<AnalyseResult> analyseResultList = groupDao.getAll(form);
        return analyseResultList;
    }
}
