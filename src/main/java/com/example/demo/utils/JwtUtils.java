package com.example.demo.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
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

    /**
     * token 过期时间，单位：秒，当前设定时间为1天
     */
    private static final Long TOKEN_EXPIRED_TIME = 60*60*24L;

    /**
     * jwt加密解密密钥，自行赋值，暂且使用随机数16位
     */
    private static  final String JWT_SECRET = "1AsdadSaS123daXX";

    public static final String jwtId = "tokenId";

    /**
     * 根据userId和openId生成token
     */

    public static String generateToken(HashMap map){

        return createJWT(map,TOKEN_EXPIRED_TIME);
    }

    public static String createJWT(Map<String,Object> claims, Long time){
        //指定签名算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        Date now = new Date(System.currentTimeMillis());
        //由字符串生成加密key
        SecretKey secretKey = generalKey();

        //生成JWT时间
        long nowMillis = System.currentTimeMillis();
        //下面就是在为payload(有效载荷，有效负荷，有效载重)添加各种标准声明和私有声明
             //JWT构建器
        JwtBuilder builder = Jwts.builder()
             //如果有私有声明，一定要先设置自己创建的私有声明，这个是给builder的clian赋值，一旦写在标准声明赋值之后，就覆盖了之前那些标准声明
                .setClaims(claims)
             //JWT的签发时间
                .setIssuedAt(now)
             //设置header
                .setHeaderParam("alg","HS256")
             //设置签名使用的签名算法和签名使用的，密钥
                .signWith(signatureAlgorithm,secretKey);
        if (time > 0){
            //过期时间 = 当前时间 + token过期时间
           Long expMillis = nowMillis + time;
            Date date = new Date(expMillis);
            //设置过期时间
            builder.setExpiration(date);
        }
        //就开始压缩为xxxxxxxxxxxxxx.xxxxxxxxxxxxxxx.xxxxxxxxxxxxx这样的jwt
        return builder.compact();

    }


    /**
     * 由字符串生成加密key
     * @return
     */
    private static SecretKey generalKey() {
        String stringKey = JWT_SECRET;
        //使用Base64去对密码进行解码
        byte[] encodeKey = Base64.decodeBase64(stringKey);
        //私密密钥设置
        SecretKey key = new SecretKeySpec(encodeKey, 0, encodeKey.length, "HS256");
        return key;
    }

    /**
     * 验证jwt,token
     *      JWT Claims
     *
     *      “iss” (issuer)  发行人
     *
     *      “sub” (subject)  主题
     *
     *      “aud” (audience) 接收方 用户
     *
     *      “exp” (expiration time) 到期时间
     *
     *      “nbf” (not before)  在此之前不可用
     *
     *      “iat” (issued at)  jwt的签发时间
     *
     *      “jti” (JWT ID)  jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击。
     */
    public static Claims verifyJwt(String token){
        //签名密钥 和生成密钥一样
        SecretKey key = generalKey();
        Claims claims;
        try{
            //parser()方法传入一个JWT字符串，返回一个JWT对象
            claims = Jwts.parser()
                    //用于设置JWT的签名key，用户后面对JWT进行解析
                    .setSigningKey(key)
                    //荷载为Claims(即Json),已签名
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            claims = null;
        }//设置需要解析的jwt
        return claims;
    }

}
