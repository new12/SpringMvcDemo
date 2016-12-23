package test.lky.cached;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import test.lky.express.StudentBean;

/**
 * Created by longkeyu on 2016/12/23.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:spring-expression.xml"})
public class BaseContext1 {
    @Autowired
    private StudentBean student;
    @Autowired
    private ApplicationContext context;
    @Test
    public void test2(){
        System.out.println("BaseContext1 " + student.getName());
        System.out.println(context);
    }
}
