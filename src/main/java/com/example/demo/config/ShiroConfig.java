package com.example.demo.config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.testng.annotations.Test;

/**
 * 2020/3/18
 *
 * @author wuzhanhao
 * <p>
 * description:
 *  shiro配置
 *
 *      @RequiresAuthentication
 * 　　验证用户是否登录，等同于方法subject.isAuthenticated() 结果为true时。
 *
 *      @RequiresPermissions
 *     要求subject中必须同时含有file:read和write:aFile.txt的权限才能执行方法someMethod()。否则抛出异常AuthorizationException。
 */
@Component
@Configuration
public class ShiroConfig{

    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();
    @Before
    public void loginUser(){
        simpleAccountRealm.addAccount("wzh","666");
    }

    @Test
    public void testAuthentication() {
        //创建SecurityManager
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        SecurityUtils.setSecurityManager(securityManager);
        securityManager.setRealm(simpleAccountRealm);
        //主题提交认证
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("wzh", "222");
        subject.login(token);

        boolean authenticated = subject.isAuthenticated();
        System.out.println(authenticated);

        subject.logout();
        System.out.println(authenticated);

    }

}
