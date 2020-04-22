package com.example.demo.dao;

import com.example.demo.entity.AnalyseResult;
import com.example.demo.entity.Form;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GroupDao {


    List<AnalyseResult> getAll(Form form);
}
