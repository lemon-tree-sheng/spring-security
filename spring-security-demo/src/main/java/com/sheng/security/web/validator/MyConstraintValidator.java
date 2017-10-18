package com.sheng.security.web.validator;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by shengxingyue on 2017/10/19.
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object>{

//    @Autowired
//    private HelloWorldService helloWorldService;

    @Override
    public void initialize(MyConstraint myConstraint) {
        System.out.println("init");
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println(o);
        return false;
    }
}
