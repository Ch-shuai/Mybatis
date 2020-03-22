package com.example.demo.controller;

import com.example.demo.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 2020/3/22
 *
 * @author Ch-shuai
 * @Description
 */
@RestController
@Api(tags = "BookController", description = "BookController | 通过书来测试swagger")
@RequestMapping(value = "/books")
public class BookController {

    Map<Long, com.example.demo.entity.User> User = Collections.synchronizedMap(new HashMap<Long, User>());

    @ApiOperation(value="创建图书", notes="创建图书")
    @ApiImplicitParam(name = "book", value = "图书详细实体", required = true, dataType = "Book")
    @RequestMapping(value="", method= RequestMethod.POST)
    public String postBook(@RequestBody Book book) {
        return "success";
    }

    @ApiOperation(value = "获图书细信息", notes = "根据url的id来获取详细信息")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getBook(@PathVariable Long id) {
        return User.get(id);
    }
}
