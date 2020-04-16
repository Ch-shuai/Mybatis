package com.example.demo.controller;

import com.example.demo.service.LayuiService;
import com.example.demo.web.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2020/4/7
 *
 * @author wuzhanhao
 * <p>
 * description:
 *
 *      该文件为测试前后端的测试文件
 */
@RestController
@RequestMapping("/layui")
public class LayuiController {

    private final LayuiService layuiService;

    /**
     *  如果显示定义了Autowired的reqired为false，则可以为空
     */
    @Autowired(required = false)
    public LayuiController(LayuiService layuiService) {
        this.layuiService = layuiService;
    }

    /**
     *  帖子管理
     */
    @PostMapping("managePost")
    public Result ManagePost(){
        Result result = layuiService.managePost();
        return result;
    }

    @PostMapping("/gongzi")
    public void getLast(Integer gongzi){
        Integer fangzu = 1500;
        Integer jiaotong = 12*25;
        Integer huabei = 500;

        Integer chifan = (5+15+15)*25;
        Integer Last = gongzi-fangzu-jiaotong-huabei-chifan;
        System.out.println(Last);
    }
}
