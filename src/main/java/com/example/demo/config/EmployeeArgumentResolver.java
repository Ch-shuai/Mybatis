package com.example.demo.config;

import com.example.demo.annotation.CurrentEmployee;
import com.example.demo.entity.Employee;
import com.example.demo.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

@Slf4j
public class EmployeeArgumentResolver implements HandlerMethodArgumentResolver {

    /**
     * 用于判定是否需要处理该参数分解，返回 true 为需要，并会去调用下面的方法resolveArgument。
     * 该解析器是否支持parameter参数的解析
     * @param methodParameter 拦截到的参数
     * @return 是否符合我们的拦截规则
     */
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {

        log.info( "judge annotation.....>" + methodParameter.hasParameterAnnotation( CurrentEmployee.class ) );
        return methodParameter.hasParameterAnnotation( CurrentEmployee.class );

    }

    /**
     * 真正用于处理参数分解的方法，返回的 Object 就是 controller 方法上的形参对象。
     */
    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        // 从请求作用域中获取请求，　
        // HttpServletRequest对象代表客户端的请求，当客户端通过HTTP协议访问服务器时，HTTP请求头中的所有信息都封装在这个对象中，通过这个对象提供的方法，可以获得客户端请求的所有信息。
        HttpServletRequest request = nativeWebRequest.getNativeRequest( HttpServletRequest.class );
        String token = request.getParameter("Authorization");
        Employee currentEmployee = null;
        if (token != null) {
            currentEmployee = JwtUtils.getEmployee( token );
        }
        return currentEmployee;
    }
}
