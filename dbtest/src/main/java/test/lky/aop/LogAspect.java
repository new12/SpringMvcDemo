package test.lky.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by longkeyu on 2016/12/12.
 */
@Aspect
@Component
public class LogAspect {

    @Around("execution(* test.lky.service.UserServiceImpl.*(..)) && @annotation(test.lky.aop.Log)")
    public Object logAround(ProceedingJoinPoint joinPoint){
        System.out.println("logAround开始:现在时间是:"+new Date()); //方法执行前的代理处理
        Object[] args = joinPoint.getArgs();
        Object obj = null;
        try {
            obj = joinPoint.proceed(args);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("logAround结束:现在时间是:"+new Date());  //方法执行后的代理处理
        return obj;
    }
}
