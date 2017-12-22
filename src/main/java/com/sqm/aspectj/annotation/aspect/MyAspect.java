package com.sqm.aspectj.annotation.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * <p>POJO类,通过注解Aspect指定为切面,方法作为不同的通知方法
 *
 * @author sqm
 * @version 1.0
 */
@Aspect
public class MyAspect {
    @Pointcut("execution(* *..UserServiceImpl.doSome())")
    private void doSomePointcut() { }

    @Before("doSomePointcut()")
    public void beforeSome() {
        System.out.println("前置增强");
    }

    @Before("execution(* *..UserServiceImpl.doOther(..))")
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


    @AfterReturning(value = "execution(* *..UserServiceImpl.doThird())", returning="result")
    public void afterReturning(JoinPoint joinPoint,Object result) {
        System.out.println("后置增强,目标方法的result:" + result);
        System.out.println("后置增强,切入点表达式:" + joinPoint);
    }

    @Around("execution(* *..UserServiceImpl.doThird())")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知,前");
        Object result = proceedingJoinPoint.proceed();
        System.out.println("环绕通知,后");
        return result;
    }

    @AfterThrowing(value = "execution(* *..annotation.*.*.UserServiceImpl.doThird())",throwing = "e")
    public void afterThrowing(Throwable e) {
        System.out.println("异常通知:" + e.getMessage());
    }

    @After("execution( * *(..))")
    public void after() {
        System.out.println("finally");
    }
}
