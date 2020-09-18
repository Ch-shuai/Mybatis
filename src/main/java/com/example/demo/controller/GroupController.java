package com.example.demo.controller;

import com.example.demo.entity.AnalyseResult;
import com.example.demo.entity.Form;
import com.example.demo.service.GroupService;
import com.example.demo.web.page.TableDataInfo;
import com.example.demo.web.page.TestData;
import com.example.demo.web.result.Result;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
@Api(description = "用户查询")
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
    @ApiOperation(value = "获取表单组合",notes = "需要前段传递相关数据")
    @ApiImplicitParams({@ApiImplicitParam(name = "name",paramType = "String",value = "公司名字")})
    public Result<TableDataInfo> getForm(@RequestBody Form form){
        Page page = new Page();
        PageHelper.startPage(1,10,true);
        List<AnalyseResult> analyseResultList = groupService.getForm(form);
        PageHelper.startPage(1,12);
        return getDataTable(analyseResultList);
    }

}
