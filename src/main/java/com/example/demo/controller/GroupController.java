package com.example.demo.controller;

import com.example.demo.entity.AnalyseResult;
import com.example.demo.entity.Form;
import com.example.demo.service.GroupService;
import com.example.demo.web.page.TableDataInfo;
import com.example.demo.web.page.TestData;
import com.example.demo.web.result.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
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
     * @param form  前段传递过来的参数
     *
     * @return
     */
    @PostMapping("/getForm")
    public Result<TableDataInfo> getForm(@RequestBody Form form){
        List<AnalyseResult> analyseResultList = groupService.getForm(form);
        return getDataTable(analyseResultList);
    }

}
