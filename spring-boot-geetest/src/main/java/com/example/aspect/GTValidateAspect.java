package com.example.aspect;

import com.example.GeetestConfig;
import com.example.GeetestLib;
import com.example.common.GTClientType;
import com.example.common.GTCondition;
import com.example.common.GTValidate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.ApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @author gaojun.zhou
 */
@Slf4j
@Aspect
@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 100)
@AllArgsConstructor
public class GTValidateAspect {

    private ApplicationContext applicationContext;

    @Pointcut("@annotation(com.example.common.GTValidate)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        HttpServletRequest request = getCurrentRequest();
        HttpServletResponse response = getCurrentResponse();
        GTValidate gtValidate = method.getAnnotation(GTValidate.class);
        GTClientType clientType = gtValidate.clientType();
        GTCondition condition = applicationContext.getBean(gtValidate.conditionalClass());

        if (condition.condition(request, response)) {
            GeetestLib gtSdk = new GeetestLib(GeetestConfig.getGeetest_id(), GeetestConfig.getGeetest_key(),
                    GeetestConfig.isnewfailback());

            String challenge = request.getParameter(GeetestLib.fn_geetest_challenge);
            String validate = request.getParameter(GeetestLib.fn_geetest_validate);
            String seccode = request.getParameter(GeetestLib.fn_geetest_seccode);

            //从session中获取gt-server状态
            int gt_server_status_code = (Integer) request.getSession().getAttribute(gtSdk.gtServerStatusSessionKey);

            //从session中获取userid
            String userid = (String) request.getSession().getAttribute("userid");

            //自定义参数,可选择添加
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("user_id", userid); //网站用户id
            param.put("client_type", clientType.getValue()); //web:电脑上的浏览器；h5:手机上的浏览器，包括移动应用内完全内置的web_view；native：通过原生SDK植入APP应用的方式
            param.put("ip_address", "127.0.0.1"); //传输用户请求验证时所携带的IP

            int gtResult = 0;

            if (gt_server_status_code == 1) {
                //gt-server正常，向gt-server进行二次验证

                gtResult = gtSdk.enhencedValidateRequest(challenge, validate, seccode, param);
                System.out.println(gtResult);
            } else {
                // gt-server非正常情况下，进行failback模式验证

                System.out.println("failback:use your own server captcha validate");
                gtResult = gtSdk.failbackValidateRequest(challenge, validate, seccode);
                System.out.println(gtResult);
            }
            if (gtResult == 1) {
                return joinPoint.proceed();
            } else {
                throw new RuntimeException("验证码错误");
            }
        }
        return joinPoint.proceed();
    }

    public static HttpServletRequest getCurrentRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public static HttpServletResponse getCurrentResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }
}
