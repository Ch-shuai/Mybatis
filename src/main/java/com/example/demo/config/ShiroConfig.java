package com.example.demo.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

/**
 * 2020/3/18
 *
 * @author wuzhanhao
 * <p>
 * description:
 *  shiro配置
 *
 *      @RequiresAuthentication
 *
 * 　　验证用户是否登录，等同于方法subject.isAuthenticated() 结果为true时。
 *
 *      @RequiresPermissions
 *     要求subject中必须同时含有file:read和write:aFile.txt的权限才能执行方法someMethod()。否则抛出异常AuthorizationException。
 */
public class ShiroConfig extends HashedCredentialsMatcher{

}
