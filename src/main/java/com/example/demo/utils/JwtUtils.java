package com.example.demo.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.entity.Employee;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 2020/3/9
 *
 * @author wuzhanhao
 *
 * @Descrption
 *      JWT的设置
 *          token包括：JWT头，有效荷载，签名
 *                     Header，Payload，Signature。
 */
public class JwtUtils {

    // 设置过期时间为8个小时
    private static final long EXPIRE_TIME = 8 * 60 * 60 * 1000;

    private static final String USER_HEAD = "user";

    /**
     * 校验token是否正确
     *
     * @param token  密钥
     * @param secret 用户的密码
     * @return 是否正确
     */
    public static boolean verify(String token, String username, String secret) {
        try {
            Algorithm algorithm = Algorithm.HMAC256( secret );
            JWTVerifier verifier = JWT.require( algorithm )
                    .withClaim( "username", username )
                    .build();
            DecodedJWT jwt = verifier.verify( token );
            return true;
        } catch (Exception exception) {
            return false;
        }

    }

    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode( token );
            return jwt.getClaim( "username" ).asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 根据token 获取用户的具体信息
     *
     * @param token
     * @return
     */
    public static Employee getEmployee(String token) {
        try {
            DecodedJWT jwt = JWT.decode( token );
            return JsonUtils.JSONStringToObj( jwt.getClaim( USER_HEAD ).asString(), Employee.class );
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 生成签名,8hou后过期
     *
     * @param username 用户名,这里可以将用户信息JSON一下,缓存起来
     * @param secret   用户的密码
     * @return 加密的token
     */
    public static String sign(String username, String secret) {
        try {
            Date date = new Date( System.currentTimeMillis() + EXPIRE_TIME );
            Algorithm algorithm = Algorithm.HMAC256( secret );
            // 附带username信息
            return JWT.create()
                    .withClaim( "username", username )
                    .withExpiresAt( date )
                    .sign( algorithm );
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    /**
     * 校验token是否正确
     *
     * @param token    密钥
     * @param employee 员工
     * @return 是否正确
     */
    public static boolean verify(String token, Employee employee) {
        try {
            Algorithm algorithm = Algorithm.HMAC256( employee.getPassword() );
            JWTVerifier verifier = JWT.require( algorithm )
                    .withClaim( USER_HEAD, JsonUtils.objToJSONString( employee ) )
                    .build();
            DecodedJWT jwt = verifier.verify( token );
            return true;
        } catch (Exception exception) {
            return false;
        }

    }

    /**
     * 将员工信息进行签名摘要加密，放入jwt
     *
     * @param employee
     * @return
     */
    public static String sign(Employee employee) {
        try {
            //设置token的过期时间
            Date date = new Date( System.currentTimeMillis() + EXPIRE_TIME );
            Algorithm algorithm = Algorithm.HMAC256( employee.getPassword() );
            // 附带username信息
            return JWT.create()
                    .withClaim( USER_HEAD, JsonUtils.objToJSONString( employee ) )
                    .withExpiresAt( date )
                    .sign( algorithm );
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }


}
