package com.sheng.security.web.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by shengxingyue on 2017/10/19.
 */
@Aspect
@Component
public class TimeAspect {

    //around 注解可以做到在业务方法的开始和结束都做处理，相对于 before,after 等更常用一些
    @Around("execution(* com.sheng.security.web.controller.UserController.*(..))")
    public Object timeAspect(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("time aspect start");

        Object[] args = pjp.getArgs();
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

        long start = new Date().getTime();
        Object o = pjp.proceed();
        System.out.println("服务耗时：" + (new Date().getTime() - start) + "ms");
        System.out.println("time aspect stop");

        return o;
    }
}
