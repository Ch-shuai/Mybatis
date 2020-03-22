package com.example.demo.controller;

import com.example.demo.service.ExcelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;

/**
 * 2020/3/10
 *
 * @author wuzhanhao
 * <p>
 * description:
 */
@RestController
@RequestMapping("/excel")
@Api("Excel导出接口")
public class ExcelCotroller {

    private final ExcelService excelService;

    @Autowired
    public ExcelCotroller(ExcelService excelService) {
        this.excelService = excelService;
    }

    @RequestMapping("")
    @ApiOperation("Excel具体导出接口")
    @PostMapping
    public void getExcel(HttpServletResponse response){
        excelService.exportExcel(response);
    }
}
