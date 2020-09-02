package com.example.demo.service.impl;

import com.example.demo.dao.CompanyCostDao;
import com.example.demo.dao.CompanyDao;
import com.example.demo.dao.CostDao;
import com.example.demo.entity.Company;
import com.example.demo.entity.CompanyCost;
import com.example.demo.entity.Cost;
import com.example.demo.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    private final CompanyCostDao companyCostDao;
    private final CompanyDao companyDao;
    private final CostDao costDao;
    @Autowired
    public DataServiceImpl(CompanyCostDao companyCostDao, CompanyDao companyDao, CostDao costDao) {
        this.companyCostDao = companyCostDao;
        this.companyDao = companyDao;
        this.costDao = costDao;
    }

    /**
     * 先生成对象再添加到数据库中
     * @param companyList
     * @param cost
     */
    @Override
    public void modifyData(List<Company> companyList, Cost cost) {
        List<CompanyCost> companyCostList = new ArrayList<>();
        for (Company company : companyList) {
            //针对于没有共性的多表，表连接越少越好，
            CompanyCost companyCost = getCompanyCost(cost, company);
            companyCostList.add(companyCost);
        }
        companyCostDao.insertList(companyCostList);
//        companyCostDao.insert(companyCost);
    }

    @Override
    public List<Company> getCompany() {
        List<Company> companyList = companyDao.getCompany();
        return companyList;
    }

    @Override
    public Cost getCost() {
        Cost cost = costDao.getCost();
        return cost;
    }

    /**
     *  将价格的参数传递给SQL语句，在SQL语句进行添加
     * @param cost
     */
    @Override
    public void modifyData2(Cost cost) {
        companyCostDao.insertByCost(cost);
    }

    //生成CompanyCost
    private CompanyCost getCompanyCost(Cost cost, Company company) {
        CompanyCost companyCost = new CompanyCost();
        companyCost.setId(company.getId());
        companyCost.setName(company.getName());
        companyCost.setFengliangBefore(company.getFengliangBefore() * cost.getFengjia());
        companyCost.setFengliangAfter(company.getFengliangAfter() * cost.getFengjia());
        companyCost.setGuliangBefore(company.getGuliangBefore() * cost.getGujia());
        companyCost.setGuliangAfter(company.getGuliangAfter() * cost.getGujia());
        companyCost.setXuliangBefore(company.getXuliangBefore() * cost.getXuliang());
        companyCost.setXuliangAfter(company.getXuliangAfter() * cost.getXuliang());
        companyCost.setJianliangBefore(company.getJianliangBefore() * cost.getJianjia());
        companyCost.setJianliangAfter(company.getJianliangAfter() * cost.getJianjia());
        return companyCost;
    }

}
