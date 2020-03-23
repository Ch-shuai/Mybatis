package com.example.demo.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 2020/3/16
 *
 * TODO
 * @author wuzhanhao
 * <p>
 * description:
 *      自定义核心组件Realm,AuthorizingRealm继承Realm，主要用于信息的认证
 */
    public class MyRealm extends AuthorizingRealm {

    /**
     * AuthorizationInfo    授权信息
     *  获取认证信息方法
     * @param principalCollection       授权对象
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Object primaryPrincipal = principalCollection.getPrimaryPrincipal();
        return null;
    }

    /**
     * @param authenticationToken       身份验证令牌
     *  对凭证信息的校验
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
}
