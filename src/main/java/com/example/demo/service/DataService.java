package com.example.demo.service;

import com.example.demo.entity.Company;
import com.example.demo.entity.Cost;

import java.util.List;

public interface DataService {

    void modifyData(List<Company> companyList, Cost cost);

    List<Company> getCompany();

    Cost getCost();

    void modifyData2(Cost cost);

}
