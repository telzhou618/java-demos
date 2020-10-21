package com.example.common;

import java.lang.annotation.*;

/**
 * @author zhougaojun
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GTValidate {

    /**
     * 客户端类型
     *
     * @see GTClientType
     */
    GTClientType clientType() default GTClientType.WEB;

    /**
     * 极验执行条件,默认 NormalGTCondition.class,需要二次验证
     */
    Class<? extends GTCondition> conditionalClass() default NormalGTCondition.class;
}
