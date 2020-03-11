package com.example.demo.controller;

import com.example.demo.entity.po.Material;
import com.example.demo.entity.Page;
import com.example.demo.service.PagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2020/3/9
 *
 * @author wuzhanhao
 */
@RestController
@RequestMapping("/mybatis")
public class PagingController {

    private final PagingService pagingService;

    @Autowired
    public PagingController(PagingService pagingService) {
        this.pagingService = pagingService;
    }

    /**
     * 第一种方法，将page和size形成动态SQL，使用limit进行查询
     * @param page  当前页
     * @param size  当前页展示的数据数量
     *       Total  总页数
     * @return
     */
    @PostMapping("/pageOne")
    public Page<Material> Page(Integer page,Integer size){
        Map<String, Object> param = new HashMap<>();

        if (page>1){
            param.put("page",(page-1)*size);
        }
        param.put("page",page);
        param.put("size",size);
        Page<Material> Page = new Page<>();
        List<Material> materialList = pagingService.getDataByPage(param);
        Long count = pagingService.count();
        Page.setRows(materialList);
        Page.setTotal(count);
        Page.setPage(page);
        Page.setSize(size);
        return Page;
    }

    /**
     * 第二种方法，从数据库里将数据全部一次性加载出来，在对list进行截取
     */
    @PostMapping("/pageTwo")
    public List<Material> PageTwo(Integer page,Integer size){
        List<Material> materialList = pagingService.getDataList(page,size);
        return materialList;
    }

    /**
     * 第三种方法，使用拦截器
     * TODO
     */
   /* @RequestMapping("/getAllBook")
    @ResponseBody
    public Page getAllBook(String pageNo, String pageSize, HttpServletRequest request, HttpServletResponse response){
        //当前页码
        pageNo=pageNo==null?"1":pageNo;
        //页面大小
        pageSize=pageSize==null?"5":pageSize;
        //获取当前页数据
        List<Material> list = pagingService.getAllBookByPage(pageNo,pageSize);
        //获取总数据大小
        Long totals = pagingService.count();
        //封装返回结果
        Page page = new Page();
        page.setTotal(totals);
        page.setRows(list);
        return page;
    }*/

}
