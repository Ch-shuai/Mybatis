package com.example.demo.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 2020/3/31
 *
 * @author wuzhanhao
 * <p>
 * description:
 *      自定义拦截器，具体详情可参考LocaleChangeInterceptor继承方式
 */
public class TestInterceptor extends HandlerInterceptorAdapter {

    /**
     *
     *  这个方法是在HandlerMapping找到对应的处理对象，但是没有请求这个对象时处理
     *      也就是在controller的方法之前执行，
     *      返回值为是否中断，
     *      true表示继续执行（下一个拦截器或处理器）
     *      false则会中断后续的所有操作，所以需要使用response来响应请求
     *
     * @param request
     * @param response
     * @param handler       这个参数就是代码中controller的方法
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("run in pre Handle");
        return true;
    }

    /**
     *
     *  在handle/controller的方法处理完逻辑后，渲染视图前执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("run in post Handle");
    }

    /**
     * 在视图渲染完之后执行，常用于资源清理，或记录日志
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    /**
     *  用于处理异步请求
     *      当Controller中有异步请求方法的时候会触发该方法时，异步请求先支持preHandle、然后执行afterConcurrentHandlingStarted。
     *      异步线程完成之后执行preHandle、postHandle、afterCompletion。
     * @param request
     * @param response
     * @param handler
     * @throws Exception
     */
    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}
