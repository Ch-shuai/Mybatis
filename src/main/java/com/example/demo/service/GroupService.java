package com.example.demo.service;

import com.example.demo.entity.AnalyseResult;
import com.example.demo.entity.Form;

import java.util.List;

public interface GroupService {
    List<AnalyseResult> getForm(Form form);
}
