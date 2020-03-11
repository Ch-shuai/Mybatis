package com.example.demo.controller;

import com.example.demo.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ExcelCotroller {

    private final ExcelService excelService;

    @Autowired
    public ExcelCotroller(ExcelService excelService) {
        this.excelService = excelService;
    }

    @RequestMapping("")
    public void getExcel(HttpServletResponse response){
        excelService.exportExcel(response);
    }
}
