package com.lys.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestInterceptor implements HandlerInterceptor {

    //拦截器
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");

        String ip = request.getRemoteAddr();

        System.out.println(ip);

        if ("0:0:0:0:0:0:0:3".equals(ip)) {
            modelAndView.addObject("msg", "该IP不可用");
            modelAndView.setViewName("demo");
        }
    }
}
