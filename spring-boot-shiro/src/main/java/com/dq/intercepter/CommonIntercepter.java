package com.dq.intercepter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author daquan
 * @version V1.0
 * @date 2020/3/3
 * @Description: 解决跨域问题
 */
@Component
public class CommonIntercepter implements HandlerInterceptor {

    /**
     * OPTIONS
     */
    private static final String OPTION = "OPTIONS";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //允许跨域,不能放在postHandle内
        response.setHeader("Access-Control-Allow-Origin", "*");
        if (OPTION.equals(request.getMethod())) {
            response.addHeader("Access-Control-Allow-Methods", "GET,HEAD,POST,PUT,DELETE,TRACE,OPTIONS,PATCH");
            /**
             * Authorization：Shiro权限验证
             */
            response.addHeader("Access-Control-Allow-Headers", "Content-Type, Accept, Authorization");
        }
        return true;
    }
}