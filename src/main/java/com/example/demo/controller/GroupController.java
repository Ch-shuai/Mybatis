package com.example.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.AnalyseResult;
import com.example.demo.service.GroupService;
import com.example.demo.web.page.TableDataInfo;
import com.example.demo.web.page.TestData;
import com.example.demo.web.result.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController extends BaseController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    /**
     * 获取表单组合
     * @param form
     * @return
     */
    @PostMapping("/getForm")
    public Result<TableDataInfo> getForm(@RequestBody String form){
        System.out.println(form);
        List<AnalyseResult> analyseResultList = groupService.getForm();
        return getDataTable(analyseResultList) ;
    }

    /**
     * test
     */
    @GetMapping("/get")
    public Result<Object> getF(@RequestBody String form){
        List<AnalyseResult> analyseResultList = groupService.getForm();
        TestData testData = new TestData();
        for (AnalyseResult analyseResult : analyseResultList) {
            BeanUtils.copyProperties(analyseResult,testData);
            testData.setRows((long) analyseResultList.size());
        }
        return Result.successData(testData);
    }

}
