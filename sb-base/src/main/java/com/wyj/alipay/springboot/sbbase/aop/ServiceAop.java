package com.wyj.alipay.springboot.sbbase.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created
 * Author: wyj
 * Date: 2018/11/19
 */
@Component
@Aspect
public class ServiceAop {

    private static final String cutPoint = "execution(* com.wyj.alipay.springboot.sbbase.service.imp.*.*(..))";


    @Around(cutPoint)
    public Object serviceAop(ProceedingJoinPoint joinPoint) throws Throwable {
        //进入方法前执行的代码
        System.out.println("--------beginAround--------");
        //执行调用的方法
        Object proceed = joinPoint.proceed();
        //方法执行完成后执行的方法
        System.out.println("---------endAround--------");
        return proceed;
    }
}
