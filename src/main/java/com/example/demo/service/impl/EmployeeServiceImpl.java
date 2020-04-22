package com.example.demo.service.impl;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONString;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.entity.Employee;
import com.example.demo.entity.vo.LoginVo;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.redis.RedisService;
import com.example.demo.utils.JsonUtils;
import com.example.demo.utils.JwtUtils;
import com.example.demo.utils.Md5SaltTool;
import com.google.code.kaptcha.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final RedisService redisService;
    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(RedisService redisService, EmployeeDao employeeDao) {
        this.redisService = redisService;
        this.employeeDao = employeeDao;
    }

    public Employee getUsername(@NotBlank(message = "登陆名称不能为空") String username) {
        return employeeDao.selectByName(username);
    }

    @Override
    public String login(LoginVo loginVo) {
        String token = null;
        //先判断前段传递进来的验证码是否和redis存储的一样
        String rightCode = redisService.get(Constants.KAPTCHA_SESSION_KEY + loginVo.getRandTime());
//        if (rightCode.equals(loginVo.getCheckcode())) {
            //验证码通过，需要进行密码盐值的判断,
            //需要先从数据库里面获取到该对象，所以要先根据username去数据库查找到相对应的数据
            Employee employee = this.getUsername(loginVo.username);
            //判断从数据库里面获取出来的数据是否为空,再根据盐值去对数据的密码进行验证
            try {
                if (employee != null || Md5SaltTool.validPassword(loginVo.getPassword(), employee.getSalt(), employee.getPassword())) {
                    //验证通过，接下来需要生成token并且加载到redis中，和shiro的验证
                    redisService.set("" + employee.getId(), JsonUtils.objToJSONString(employee), 8 * 60 * 60 * 1000L);
                    //注册token
                    token = JwtUtils.sign(employee);
                    return token;
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
//        }
        return token;
    }
}
