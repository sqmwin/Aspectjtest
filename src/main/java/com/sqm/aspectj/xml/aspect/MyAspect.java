package com.sqm.aspectj.xml.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * <p>POJO类,通过xml配置文件指定为切面,方法作为不同的通知方法
 *
 * @author sqm
 * @version 1.0
 */
public class MyAspect {
    private void doSomePointcut() { }

    public void beforeSome() {
        System.out.println("前置增强");
    }

    public void beforeOther(JoinPoint joinPoint) {
        System.out.println("前置增强-切入点表达式:" + joinPoint);
        System.out.println("前置增强-方法签名:" + joinPoint.getSignature());
        System.out.println("前置增强-目标对象:" + joinPoint.getTarget());

        Object[] args = joinPoint.getArgs();
        if (args.length > 0) {
            System.out.print("前置增强-方法参数为:");
            for (Object arg : args) {
                System.out.print(arg + " ");
            }
            System.out.println();
        }
    }


    public void afterReturning(JoinPoint joinPoint,Object result) {
        System.out.println("后置增强,目标方法的result:" + result);
        System.out.println("后置增强,切入点表达式:" + joinPoint);
    }

    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知,前");
        Object result = proceedingJoinPoint.proceed();
        System.out.println("环绕通知,后");
        return result;
    }

    public void afterThrowing(Throwable e) {
        System.out.println("异常通知:" + e.getMessage());
    }

    public void after() {
        System.out.println("finally");
    }
}
