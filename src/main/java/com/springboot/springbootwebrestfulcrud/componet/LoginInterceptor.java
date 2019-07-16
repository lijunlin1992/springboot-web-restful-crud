package com.springboot.springbootwebrestfulcrud.componet;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器，用于拦截登录认证
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser==null){
            //未登录的请求，转发到登录页面
            request.setAttribute("msg","请登录");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }else{
            return true;
        }
    }
}
