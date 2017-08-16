package com.foo.aspect;

import com.foo.annotions.MyAction;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 应用场景总结：
 * 1.事物 2.日志 （http://blog.csdn.net/czmchen/article/details/42392985）3.缓存
 * Created by jianguang he on 2017/8/15.
 */
@Aspect
@Component
public class MyAspect {


    /**
     * 生明切点
     */
    @Pointcut("@annotation(com.foo.annotions.MyAction)")
    public void annotaionPointCut(){}


    /**
     * 声明一个建言 使用上面定义的切点
     * @param joinPoint
     */
    @After("annotaionPointCut()")
    public void after(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        MyAction myAction = method.getAnnotation(MyAction.class);
        System.out.println("_________" + myAction.name());
    }

    /**
     * 方法二 直接使用拦截规则作为参数
     *
     * 1) JoinPoint：提供访问当前被通知方法的目标对象、代理对象、方法参数等数据：
     * 2）ProceedingJoinPoint：用于环绕通知，使用proceed()方法来执行目标方法：
     * 3) JoinPoint.StaticPart：提供访问连接点的静态部分，如被通知方法签名、连接点类型等：
     * @param joinPoint
     */
    @Around("execution(* com.foo.service.AspectService.aspectTest(..))")
    public void before(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        MyAction myAction = method.getAnnotation(MyAction.class);
        Object data = joinPoint.proceed(); //ProceedingJoinPoint：用于环绕通知，使用proceed()方法来执行目标方法：
        System.out.println("方法式拦截：" + myAction.name() + "return value:" + data.toString());
    }


    @Before(value = "execution(* com.foo.service.AspectService.aspectTest(*)) && args(params)", argNames = "params")
    public void before1(String params){
        System.out.println("*********:" + params);
    }

}
