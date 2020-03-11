package com.example.demo.controller;

import com.example.demo.entity.po.Material;
import com.example.demo.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 2020/3/8
 *
 * @author Ch-shuai
 * @Description
 */
@RestController
@RequestMapping("/Material")
public class MaterialController {

    private final MaterialService materialService;

    @Autowired
    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @RequestMapping("")
    public List<Material> getAllData(){
        List<Material> materialList = materialService.getData();
        return materialList;
    }
    @RequestMapping("/map")
    public Map<Integer,Object> getMap(){
        Map<Integer,Object> map = materialService.getMap();
        return map;
    }
}
