package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * 创建一个注解，用于标示员工。将来使用页面渲染的时候进行添加注解
 * @author wuzhanhao
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentEmployee {

    boolean required() default true;
}
