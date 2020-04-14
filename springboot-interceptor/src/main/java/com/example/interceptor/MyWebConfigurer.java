package com.example.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author jameszhou
 */
@Slf4j
@Configuration
public class MyWebConfigurer implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        /**
         * 拦截 /admin 开头的请求
         */
        registry.addInterceptor(new SessionHandlerInterceptor()).addPathPatterns("/admin/**");
    }


    class SessionHandlerInterceptor implements HandlerInterceptor {

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            log.info("方法执行前调用此方法!");
            // 模拟管理员登录
            String username = request.getParameter("username");
            if (Objects.equals(username,"admin")) {
                return true;
            } else {
                log.error("拒绝访问!");
                response.sendError(HttpStatus.UNAUTHORIZED.value());
                return false;
            }
        }

        @Override
        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
            log.info("方法执行后调用此方法！");
        }

        @Override
        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
            log.info("页面渲染完毕后调用此方法！");
        }
    }
}
