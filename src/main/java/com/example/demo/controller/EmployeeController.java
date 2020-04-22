package com.example.demo.controller;

import com.example.demo.entity.vo.LoginVo;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * @author wuzhanhao
 *
 * 这是用户登陆的controller
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    /**
     * 要进行登陆，
     *  1。先判断验证码是否正确,由于是根据JWT来进行判断，所以需要先生成一个JWT
     *  2。判断用户是否存在
     *  3。根据shiro来进行权限判断
     */
    @PostMapping("/login")
    @ResponseBody
    public String login(@Valid LoginVo loginVo){
        return employeeService.login(loginVo);
    }

    /**
     * 由于前端需要根据状态来进行判断
     *    data: T;
     *   status: number;
     *   statusText: string;
     *   headers: any;
     *   config: AxiosRequestConfig;
     *   request?: any;
     */

}
