package com.kkb.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 */
public class myInterceptor implements HandlerInterceptor {

    //执行时机: 控制器方法执行之前,在ModelAndView返回之前执行 , 有机会修改返回值
    //使用场景: 登录验证
    // 返回值 true  : 表示放行 继续执行控制器方法
    //       false : 表示拦截 中断执行控制器方法(不继续执行)
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle-------------");
        return true;
    }
    //执行时机: 控制器方法执行之后 , 在ModelAndView返回之前执行 , 有机会修改返回值
    //使用场景: 日记记录,记录登录的ip,时间
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle------------");
    }
    //执行时机: 控制器方法执行之后 , 在ModelAndView返回之前执后 , 没有机会修改返回值
    //使用场景: 全局资源 操作(释放)
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion--------");
    }
}
