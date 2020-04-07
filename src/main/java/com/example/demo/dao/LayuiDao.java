package com.example.demo.dao;

import com.example.demo.entity.article;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.ArrayList;

/**
 * 2020/4/7
 *
 * @author wuzhanhao
 * <p>
 * description:
 */
@Mapper
public interface LayuiDao extends BaseMapper<article> {

    ArrayList<article> getPost();
}
