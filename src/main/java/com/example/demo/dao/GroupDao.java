package com.example.demo.dao;

import com.example.demo.entity.AnalyseResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GroupDao {


    List<AnalyseResult> getAll();
}
