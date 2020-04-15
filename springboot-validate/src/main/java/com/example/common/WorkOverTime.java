package com.example.common;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author jameszhou
 */
@Constraint(validatedBy = {WorkOverTimeValidator.class})
@Documented
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface WorkOverTime {

    String message() default "工作时长不能超过{max}小时";

    int max() default 8;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
