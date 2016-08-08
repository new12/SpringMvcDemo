package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Aspect
public class LogAspect {

    private Map<String,Integer> maps = new HashMap<String,Integer>();

    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);
    @Pointcut(
            "execution(* service.JobService.findByName(String)) && args(name)")
    public void log(String name){}

    @Before(value = "log(name)")
    public void record(String name){
        Integer integer = maps.get(name);
        if (integer==null) integer = 1;
        else integer=integer+1;
        maps.put(name,integer);
        System.out.println("name:"+name+",value:"+integer);
    }

}
