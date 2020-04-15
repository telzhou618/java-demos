package com.example.common;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author jameszhou
 */
public class WorkOverTimeValidator implements ConstraintValidator<WorkOverTime, Integer> {
    private WorkOverTime workOverTime;
    private int max;

    @Override
    public void initialize(WorkOverTime workOverTime) {
        this.workOverTime = workOverTime;
        max = workOverTime.max();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return true;
        }
        return value <= max;
    }
}
