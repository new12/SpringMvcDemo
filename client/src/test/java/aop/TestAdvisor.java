package aop;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.Interceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectInstanceFactory;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.aspectj.AspectJMethodBeforeAdvice;
import org.springframework.aop.aspectj.SimpleAspectInstanceFactory;
import org.springframework.cglib.proxy.MethodInterceptor;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/**
 * Created by kylong on 2016/7/26.
 */
public class TestAdvisor extends AspectJMethodBeforeAdvice {


    public TestAdvisor(Method aspectJBeforeAdviceMethod, AspectJExpressionPointcut pointcut, AspectInstanceFactory aif) {
        super(aspectJBeforeAdviceMethod, pointcut, aif);
    }
}
